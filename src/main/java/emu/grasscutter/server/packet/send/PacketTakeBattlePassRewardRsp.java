package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption;
import emu.grasscutter.net.proto.ItemParamOuterClass.ItemParam;
import emu.grasscutter.net.proto.TakeBattlePassRewardRspOuterClass.TakeBattlePassRewardRsp;
import emu.grasscutter.server.game.GameSession;

import java.util.List;

public class PacketTakeBattlePassRewardRsp extends BasePacket {
    public PacketTakeBattlePassRewardRsp(List<BattlePassRewardTakeOption> takeOptionList, List<ItemParamData> rewardItems) {
        super(PacketOpcodes.TakeBattlePassRewardRsp);

        var proto = TakeBattlePassRewardRsp.newBuilder()
        		.addAllTakeOptionList(takeOptionList);
        
        if (rewardItems != null) {
        	for (ItemParamData param : rewardItems) {
            	proto.addItemList(ItemParam.newBuilder().setItemId(param.getItemId()).setCount(param.getCount()));
            }
        }

        setData(proto);
    }
}
