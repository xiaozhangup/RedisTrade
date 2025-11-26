package dev.unnm3d.redistrade.configs;


import de.exlll.configlib.Comment;
import de.exlll.configlib.Configuration;
import de.exlll.configlib.YamlConfigurationProperties;
import de.exlll.configlib.YamlConfigurations;
import dev.unnm3d.redistrade.utils.MyItemBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

@Configuration
public class GuiSettings {
    private static GuiSettings SETTINGS;

    public static GuiSettings instance() {
        return SETTINGS;
    }

    public static void loadGuiSettings(Path configFile) {
        SETTINGS = YamlConfigurations.update(
                configFile,
                GuiSettings.class,
                YamlConfigurationProperties.newBuilder()
                        .header("RedisTrade guis")
                        .footer("Authors: Unnm3d")
                        .charset(StandardCharsets.UTF_8)
                        .build()
        );
    }

    public static void saveGuiSettings(Path configFile) {
        YamlConfigurations.save(configFile, GuiSettings.class, SETTINGS,
                YamlConfigurationProperties.newBuilder()
                        .header("RedisTrade guis")
                        .footer("Authors: Unnm3d")
                        .charset(StandardCharsets.UTF_8)
                        .build()
        );
    }

    @Comment({"C - Confirm trade, M - First currency, N - Second currency, O - Third currency, L - Trader side,",
            "r - Receipt Slot, v - Profile button, V - Rating button (shown on trade completion), x - Background item, D - Cancel trade,",
            "o - Customer first currency, n - Customer second currency, m - Customer third currency, c - Customer confirm trade, R - Customer side",
            "CAUTION!: This configuration must be the same on every instance of RedisTrade"})
    public List<String> tradeGuiStructure = List.of(
            "CMNODonmc",
            "LLLLrRRRR",
            "LLLLvRRRR",
            "LLLLVRRRR",
            "LLLLxRRRR",
            "LLLLxRRRR");

    public String tradeGuiTitle = "与 %player% 交易";
    public String ratingMenuTitle = "评价 %player% 的交易物品";
    public String moneyEditorTitle = "修改 %currency% 数量";
    public String moneyEditorLabel = "数量";

    public SimpleSerializableItem nextPage = new SimpleSerializableItem("ARROW", 1, 0, "<blue>下一页", List.of());
    public SimpleSerializableItem previousPage = new SimpleSerializableItem("ARROW", 1, 0, "<blue>上一页", List.of());
    public SimpleSerializableItem refuseButton = new SimpleSerializableItem("RED_WOOL", 1, 0, "<red>拒绝交易", List.of("", "<white>点击 <dark_green>确认</dark_green> 交易</white>"));
    public SimpleSerializableItem confirmButton = new SimpleSerializableItem("GREEN_WOOL", 1, 0, "<green>确认交易", List.of("", "<white>点击 <red>拒绝</red> 交易</white>"));
    public SimpleSerializableItem cancelConfirmedButton = new SimpleSerializableItem("GRAY_DYE", 1, 0, "<red>取消交易", List.of("<white><red>拒绝</red>交易", "<white>如果你想取消交易"));
    public SimpleSerializableItem cancelTradeButton = new SimpleSerializableItem("BARRIER", 1, 0, "<red>取消交易", List.of("", "<white>点击 <red>取消</red> 交易</white>", "<white>并取回你的所有物品</white>"));
    public SimpleSerializableItem getAllItems = new SimpleSerializableItem("ENDER_EYE", 1, 0, "<aqua>取回所有物品", List.of("", "<white>点击 <green>返还</green> 所有物品</white>", "<white>到你的背包</white>"));
    public SimpleSerializableItem completedButton = new SimpleSerializableItem("LIME_WOOL", 1, 0, "<green>交易完成", List.of(""));
    public SimpleSerializableItem retrievedButton = new SimpleSerializableItem("LIGHT_BLUE_WOOL", 1, 0, "<blue>已取回物品", List.of(""));
    public SimpleSerializableItem moneyDisplay = new SimpleSerializableItem("GOLD_NUGGET", 1, 0, "<yellow>%amount% %currency%", List.of());
    public SimpleSerializableItem moneyConfirmButton = new SimpleSerializableItem("GOLD_BLOCK", 1, 0, "<yellow>确认", List.of());
    public SimpleSerializableItem rateItem = new SimpleSerializableItem("NETHER_STAR", 1, 0, "<yellow>%stars%", List.of("<white>给交易评 %rating% 星"));
    public SimpleSerializableItem playerProfile = new SimpleSerializableItem("PLAYER_HEAD", 1, 0, "<yellow>%player_name%",
            List.of("<white>评分: <gold>%stars%</gold> 或 <aqua>%rating%</aqua>", "完成交易数: %trade_count%", ""));
    public SimpleSerializableItem separator = new SimpleSerializableItem("GRAY_STAINED_GLASS_PANE", 1, 0, "", List.of());
    public SimpleSerializableItem openRatingMenu = new SimpleSerializableItem("NETHER_STAR", 1, 0, "<yellow>评价此交易", List.of("<white>你可以在收据中编辑你的评分"));

    public String xpBottleDisplayName = "<green>瓶装经验 (%amount% 点)";

    @Comment({"Remember that a book line contains 20 large characters",
            "(if you use 'i's or 'l's it will be contain more characters)",
            "\"default\" is the name of the currency name of the displayed price or symbol"})
    public List<List<String>> receiptIntestationFormat = List.of(
            List.of(
                    "交易收据",
                    "",
                    "<black>卖家: <blue>%trader%</blue>",
                    "",
                    "<black>买家: <blue>%customer%</blue>",
                    "",
                    "日期: ",
                    "<blue>%timestamp%</blue>",
                    "",
                    "卖家价格: <gold>%price_default_trader%%symbol_default%</gold>",
                    "买家价格: <gold>%price_default_customer%%symbol_default%</gold>",
                    "<click:run_command:/trade-rate set %trade_uuid%>[<blue>评价此交易</blue>]</click>",
                    "<click:run_command:/trade-rate show-trade %trade_uuid%>[<blue>查看交易评价</blue>]</click>"
            )
    );

    public String receiptBookDisplayName = "<!i>%trader% 的收据";

    @Comment({"Remember that a book line contains 20 large characters",
            "(if you use 'i's or 'l's it will be contain more characters)",
            "\"default\" is the name of the currency name of the displayed price or symbol"})
    public List<String> receiptBookLore = List.of(
            "卖家: <blue>%trader%</blue>",
            "买家: <blue>%customer%</blue>",
            "日期: ",
            "<blue>%timestamp%</blue>",
            "卖家价格: <gold>%price_default_trader%%symbol_default%</gold>",
            "买家价格: <gold>%price_default_customer%%symbol_default%</gold>",
            "交换的物品:",
            "%items%"
    );
    public String itemDisplayLoreFormat = "<!i><gray>[x%amount% %item_display%]";

    public String traderItemsIntestation = "<bold>卖家物品: </bold>";
    public String customerItemsIntestation = "<bold>买家物品: </bold>";
    @Comment("%item_name% - item displayname or itemname or , %amount% - item amount")
    public String itemFormat = "<dark_gray>[x%amount% %item_name%]";


    public record SimpleSerializableItem(String material, int amount, int customModelData, String itemName,
                                         List<String> lore) {
        public static SimpleSerializableItem fromItemStack(@NotNull ItemStack item) {
            final String serializedItemName = MiniMessage.miniMessage().serialize(
                    item.getItemMeta().hasDisplayName() ?
                            item.getItemMeta().displayName() :
                            item.getItemMeta().hasItemName() ?
                                    item.getItemMeta().itemName() :
                                    Component.empty());
            final List<String> serializedLore = item.getItemMeta().hasLore() ?
                    item.getItemMeta().lore().stream()
                            .map(MiniMessage.miniMessage()::serialize)
                            .toList() :
                    List.of();

            return new SimpleSerializableItem(
                    item.getType().name(),
                    item.getAmount(),
                    item.getItemMeta().hasCustomModelData() ?
                            item.getItemMeta().getCustomModelData() :
                            0,
                    serializedItemName,
                    serializedLore
            );
        }

        public MyItemBuilder toItemBuilder() {
            Material mat = Material.getMaterial(material);
            if (mat == null) {
                throw new IllegalArgumentException("Material " + material + " not found in this MC version");
            }
            final MyItemBuilder builder = new MyItemBuilder(mat);
            builder.setAmount(amount);
            builder.setCustomModelData(customModelData);
            builder.setMiniMessageItemName(itemName);
            builder.addMiniMessageLoreLines(lore.toArray(new String[0]));
            return builder;
        }
    }
}
