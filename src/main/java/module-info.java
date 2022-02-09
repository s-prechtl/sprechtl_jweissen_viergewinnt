module us.jost.sprechtl_jweissen_viergewinnt {
    requires javafx.controls;
    requires javafx.fxml;


    opens us.jost.sprechtl_jweissen_viergewinnt to javafx.fxml;
    exports us.jost.sprechtl_jweissen_viergewinnt;
    exports us.jost.sprechtl_jweissen_viergewinnt.controller;
    exports us.jost.sprechtl_jweissen_viergewinnt.model;
    opens us.jost.sprechtl_jweissen_viergewinnt.controller to javafx.fxml;
}