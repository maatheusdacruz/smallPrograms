package br.com.supermarket;

import br.com.supermarket.controller.BancoDeDados;
import br.com.supermarket.model.CategoryItem;
import br.com.supermarket.model.Item;
import br.com.supermarket.model.Market;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BancoDeDados b = new BancoDeDados();
        b.readFile();
//        Market market = new Market("Best Price Market");

//        market.showItems();


    }

}