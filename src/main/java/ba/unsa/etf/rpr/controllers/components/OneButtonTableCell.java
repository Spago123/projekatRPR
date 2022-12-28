package ba.unsa.etf.rpr.controllers.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class OneButtonTableCell<T> extends TableCell<T, T> {

    private Button view;
    public OneButtonTableCell(EventHandler<ActionEvent> buttonOne) {
        view = new Button("View");
        view.setOnAction(buttonOne);
    }



}
