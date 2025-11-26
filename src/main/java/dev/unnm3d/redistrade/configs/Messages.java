package dev.unnm3d.redistrade.configs;


import de.exlll.configlib.Configuration;
import de.exlll.configlib.YamlConfigurations;
import dev.unnm3d.redistrade.restriction.KnownRestriction;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Configuration
public class Messages {
    private static Messages SETTINGS;


    public static Messages instance() {
        return SETTINGS;
    }

    public static void loadMessages(Path configFile) {
        SETTINGS = YamlConfigurations.update(configFile, Messages.class);
    }

    public String cmdCooldown = "<red>请稍等片刻再使用此命令";
    public String noPermission = "<red>你没有权限执行此操作";
    public String alreadyInTrade = "<red>你正在与 %player% 交易中 <click:run_command:'/trade'><dark_aqua>[点击继续或执行 /trade]</dark_aqua></click>";
    public String noPendingTrades = "<red>你没有待处理的交易";
    public String noPendingTradesOther = "<red>%player% 没有待处理的交易";
    public String tradeNotFound = "<red>未找到交易";
    public String targetAlreadyInTrade = "<red>玩家 %player% 正在与其他人交易中";
    public String tradeCreated = "<gradient:green:gray>你发起了与 %player% 的交易<br><dark_aqua><click:run_command:'/trade %player%'>[点击打开]</click> <white>或</white>执行 /trade %player%</dark_aqua>";
    public String tradeReceived = "<green>%player% 想与你交易 <click:run_command:'/trade %player%'><dark_aqua>[点击打开或执行 /trade %player%]</dark_aqua></click>";
    public String setItemField = "<green>你已成功将物品设置为 %field%";
    public String getItemField = "<green>你已成功将物品 %field% 放入背包";
    public String completionTimer = "<green>交易将在 %time% 秒后完成";
    public String playerNotFound = "<red>未找到玩家 %player%";
    public String tradeDistance = "<red>你必须与对方保持至少 %blocks% 格距离才能交易";
    public String notEnoughMoney = "<red>你没有足够的货币";
    public String invalidFormat = "<red>格式无效";
    public String tradeWithYourself = "<red>你不能与自己交易";
    public String tradeUnignored = "<green>你已取消屏蔽 %player% 的交易请求";
    public String tradeIgnored = "<green>你已屏蔽 %player% 的交易请求";
    public String tradeIgnoreList = "<green>已屏蔽的玩家: %list%";
    public String blacklistedItem = "<red>你不能交易此物品，它在黑名单中";
    public String notSupported = "<red>此功能不支持 %feature%";
    public List<String> moneyButtonLore = List.of("<white>货币: %currency%",
            "数量: <gold>%amount%%symbol%");
    public String confirmMoneyDisplay = "<green>确认价格 %amount%%symbol%";
    public String tradeRunning = "<color:#39abab>交易仍在后台进行中</color><br><color:#bfbfbf><click:run_command:'/trade %player%'>[点击继续]</click> 或 <click:suggest_command:'/trade'>[/trade]</click>";
    public String newTradesLock = "<red>抱歉给你带来不便。目前存在临时同步问题<br>请稍后再试";
    public String tradeRated = "<green>你给这笔交易评了 %rate% 星";
    public String playerShowRating = "<green>%player% 的评分是 %mean% 或 <yellow>%stars%</yellow>，共 %count% 笔交易";
    public String tradeShowNoRating = "<green>%trader_name% 尚未评价此交易";
    public String tradeShowRating = "<green>%reviewer% 对 %reviewed% 的评价: <yellow>%stars%</yellow>";
    public String tradeWindowClosed = "<aqua>你的交易已转入后台<br><color:#bfbfbf><click:run_command:'/trade %player%'>[点击继续]</click> 或 <click:suggest_command:'/trade'>[/trade]</click><br><red>你在交易时做了不被允许的操作";
    public String tradeRestricted = "<red>你无法打开交易窗口，因为你做了不被允许的操作：移动、受到伤害、正在战斗";
    public Map<String, String> restrictionMessages = Map.of(
            KnownRestriction.MOVED.toString(), "<red>交易时不能移动",
            KnownRestriction.DAMAGED.toString(), "<red>交易时不能受到伤害",
            KnownRestriction.COMBAT.toString(), "<red>交易时不能处于战斗状态",
            KnownRestriction.WORLD_CHANGE.toString(), "<red>交易时不能切换世界",
            "WORLD_GUARD", "<red>你不能在此区域进行交易"
    );
}
