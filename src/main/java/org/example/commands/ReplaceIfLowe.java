package org.example.commands;

import org.example.exeptions.ExitWhileExecuting;
import org.example.models.Ticket;
import org.example.models.creators.TicketCreator;
import org.example.managers.CollectionManager;

import java.util.Scanner;

public class ReplaceIfLowe extends Command implements Executable {


    public ReplaceIfLowe() {
    }

    public ReplaceIfLowe(int wordsCount) {
        super(wordsCount);
    }

    public ReplaceIfLowe(CollectionManager collectionManager) {
        super(collectionManager);
    }

    public ReplaceIfLowe(int wordsCount, CollectionManager collectionManager) {
        super(wordsCount, collectionManager);
    }

    @Override
    public void execute(String[] splitedConsoleRead) {
        Scanner consoleRead = new Scanner(System.in);
        Ticket ticket = TicketCreator.createTicket("Создание билета для сравнения !цены! и возможной последующей замены");
        System.out.println("Ваш созданный билет:\n"+ticket.toString());


        boolean pass=true;
        try {
            do {
                System.out.println("Доступные ключи для доступа к билетам : " + this.collectionManager.getCollection().keySet());
                System.out.println("Введите ключ");
                String key = consoleRead.nextLine();
                if (key.equals("exit")){
                    System.out.println("Возвращение на домашнюю страницу");
                    throw new ExitWhileExecuting("Выход во время обновления по id");
                }
                if (this.collectionManager.getCollection().containsKey(key)) {
                    System.out.println(this.collectionManager.getCollection().get(key).toString());
                    System.out.println("Вы хотели сравнить с этим билетом?\n1 : да\n2 : нет\n3 : прервать замену билета");
                    String userDecision = consoleRead.nextLine().trim();
                    switch (userDecision){
                        case ("1"):
                            pass=false;
                            if (this.collectionManager.getCollection().get(key).getPrice()>ticket.getPrice()){
                                this.collectionManager.getCollection().replace(key,ticket);
                                System.out.println("Билет успешно обновлен!");
                            }else {
                                System.out.println("Билет не обновлен: новая цена больше старой");
                            }
                            break;
                        case ("2"):
                            break;
                        case ("3"):
                            pass=false;
                            System.out.println("Замена билета прервана!");
                            break;
                        default:
                            System.out.println("Должно быть введено значение, равное '1' или '2'");
                    }
                } else {
                    System.out.println("Ключ введен неверно");
                }
            }while (pass);
        } catch (ExitWhileExecuting exeption) {
            return;
        }
    }

    @Override
    public String toString() {
        return "replace_if_lowe";
    }

    @Override
    public void describe() {
        System.out.println("replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого");
    }
}
