package org.champenslabyaddons.fvplus.commands;

import net.labymod.api.client.chat.command.Command;
import org.champenslabyaddons.fvplus.util.Messaging;

public class TestPoiCommand extends Command {
  public TestPoiCommand() {
    super("testpoi", "tpc");
  }


  @Override
  public boolean execute(String prefix, String[] arguments) {
    if (arguments.length < 1) {
      return true;
    }
    switch (arguments[0]) {
      case "a":
        Messaging.executor().displayClientMessage("VAGT-ALARM: _ghost_v2 forsøger at røve vagternes værdi-boks i A!");
        break;
      case "a2":
        Messaging.executor().displayClientMessage("VAGT-ALARM: _ghost_v2 gennemførte et røveri i vagternes værdi-boks i A!");
        break;
      case "a+":
        Messaging.executor().displayClientMessage("VAGT-ALARM: L433E prøver at bryde pengeskabet op i banken i A+ Området!");
        break;
      case "a+2":
        Messaging.executor().displayClientMessage("VAGT-ALARM: Det lykkedes L433E at bryde bankens pengeskab op i A+ Området!");
        break;
      case "b":
        Messaging.executor().displayClientMessage("VAGT-ALARM: Willads_den_seje har stjålet inventar fra Vagt-Huset B!");
        break;
      case "b+":
        Messaging.executor().displayClientMessage("VAGT-ALARM: HvilkenDag prøver at bryde pengeskabet op i banken i B+ Området!");
        break;
      case "b+2":
        Messaging.executor().displayClientMessage("VAGT-ALARM: Det lykkedes HvilkenDag at bryde bankens pengeskab op i B+ Området!");
        break;
      case "c":
        Messaging.executor().displayClientMessage("| FV-PRISON | VAGT-ALARM: Rikard har haft fingrene i Vagt-Vaulten i C!");
        break;
      case "bbo":
        Messaging.executor().displayClientMessage("[Bande-Område] NikoKjaer prøver at overtage Bande Området for hans bande i B!");
        break;
      case "bbo2":
        Messaging.executor().displayClientMessage("[Bande-Område] Det lykkedes NikoKjaer at overtage Bande Området!");
        break;
      case "bbo+":
        Messaging.executor().displayClientMessage("[B+Bande-Område] Pandasic1 prøver at overtage B+Bande Området for hans bande!");
        break;
      case "bbo+2":
        Messaging.executor().displayClientMessage("[B+Bande-Område] Det lykkedes Pandasic1 at overtage B+Bande Området!");
        break;
      case "abo":
        Messaging.executor().displayClientMessage("[Bande-Område] ViktorPVPer prøver at overtage Bande Området for hans bande!");
        break;
      case "abo2":
        Messaging.executor().displayClientMessage("[Bande-Område] Det lykkedes ViktorPVPer at overtage Bande Området!");
        break;
      case "abo+":
        Messaging.executor().displayClientMessage("[A+Bande-Område] EliasBlack_ prøver at overtage A+ Bande Området for hans bande!");
        break;
      case "abo+2":
        Messaging.executor().displayClientMessage("[A+Bande-Område] Det lykkedes EliasBlack_ at overtage A+Bande Området!");
        break;
    }
    return true;
  }
}
