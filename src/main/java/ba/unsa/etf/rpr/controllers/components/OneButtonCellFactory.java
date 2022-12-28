package ba.unsa.etf.rpr.controllers.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;




public class OneButtonCellFactory<T> implements Callback<TableColumn<T, T>, TableCell<T, T>> {
    private final EventHandler<ActionEvent> buttonOne;

    public OneButtonCellFactory(EventHandler<ActionEvent> buttonOne) {
        this.buttonOne = buttonOne;
    }


    @Override
    public TableCell<T, T> call(TableColumn<T, T> ttTableColumn) {
        return new OneButtonTableCell<>(buttonOne);
    }
}
