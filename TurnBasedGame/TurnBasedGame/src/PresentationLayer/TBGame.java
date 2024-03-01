package PresentationLayer;
import java.util.*;

import BusinessLayer.*;
import BusinessLayer.Opponent;


public class TBGame {
    static ArrayList<Opponent> opponentList;
    //queue
    private ArrayList<Opponent> opponentArraytList;
    private ArrayList<Human> humanArrayList;
    Queue<Turn> queue;
    Menu menu;


    public static ArrayList<Opponent> getOpponentList() {
        return opponentList;
    }

    public TBGame() {
        menu = new Menu();
        Initializer init = new Initializer();
        opponentArraytList = init.createOpponents();
        menu.displayOpponent(opponentArraytList);
        humanArrayList = init.createHumans();
        queue = init.createQueue(opponentArraytList, humanArrayList);

    }

    //We added a method when taking integer inputs used exception handling while doing so
    public static int userIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean isValid = false;

        while (!isValid) {

            try {
                num = Integer.parseInt(scanner.nextLine());
                isValid = true; // If parseInt doesn't throw an exception, input is valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return num;
    }


    //The proper way would be defining these inner classes as private but
    //We had limited time due to this homeworks' complexity and even though
    //we started working on it quite early we had limited time especially for our TBGame class
    //So we had to focus on our codes readability and functionality Focusing on
    //functionality was quite crucial but this doesn't mean that we didn't try our best
    //to make this project a proper well designed OOP Project
    //as we don't want a project that gives out wrong outputs

    public class Menu {

        int opponentBeingAttack;
        String humanBeingAttack;

        //displayer method
        public void humanChoiceMenu() {

            System.out.println("""
                            [1] Punch                                      
                            [2] Attack with weapon
                            [3] Guard
                            [4] Special Action
                            [5] Run
                            Please select your action:
                                           """);

        }



        public void startGame() {
            System.out.println("The battle starts. ");
            attackController();
            System.out.println("BİTTİ");
        }

        //Start screen and displaying the randomly initialized opponents
        public void displayOpponent(ArrayList<Opponent> opponentList) {
            System.out.println("Welcome to TBGame!\n" +
                    "These opponents appeared in front of you: ");
            for (Opponent element : opponentList
            ) {
                System.out.println(element.toString());
            }

        }

        //It returns which member this Turn belongs to.
        public Member findTurnMember(Turn turn, ArrayList<Opponent> oplist, ArrayList<Human> humlist) {

            for (int i = 0; i < oplist.size(); i++) {

                Opponent op = oplist.get(i);


                if (turn.getOwnerIdOrName().trim().equals(String.valueOf(op.getOpponentId()).trim())) {

                    return op;
                }
            }

            for (int i = 0; i < humlist.size(); i++) {

                Human hmn = humlist.get(i);

                if (turn.getOwnerIdOrName().trim().equals(hmn.getName().trim())) {

                    return hmn;
                }
            }
            System.out.println("we are returning null here if this prints out.");
            return null;
        }

        //This method should take the Opponent which has the current turn as parameter


        //if humanSelect == 2 do this
        //This method should take the Human which has the current turn as parameter
        public int weaponSpecialAttackTypeSelection(Human human) {
            if (human == null) {
                System.out.println("Human is null, cannot select weapon.");
                return -1; // veya başka bir değer döndürebilirsin
            }

            switch (human.getWeapon().getWeaponType()) {
                case "Bow":
                    System.out.println("[1] Single arrow attack");
                    System.out.println("[2] Two arrows attack");
                    break;
                case "Sword":
                    System.out.println("[1] Slash");
                    System.out.println("[2] Stab");
                    break;
                case "Spear":
                    System.out.println("[1] Stab");
                    System.out.println("[2] Thrown");
                    break;
                default:

            }

            Scanner scanner = new Scanner(System.in);
            int weaponSelect = scanner.nextInt();

            return weaponSelect;
        }

        //This method is for User to select the Opponent that the Human object will attack
        public Opponent determineOpponent(ArrayList<Opponent> oplist) {
            //This null can be quite detrimental if not handled properly.
            //but at this instance the null exceptions that can arise had taken care of.
            Opponent determinedOp = null;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an opponent");
            int opponentIdSelect = userIntegerInput();
            for (int i = 0; i < oplist.size(); i++) {
                int idcheck = oplist.get(i).getOpponentId();
                if (opponentIdSelect == idcheck) {
                    determinedOp = oplist.get(i);
                }
            }
            try {
                if (determinedOp == null) {
                    throw new NullPointerException("Opponent not found!");
                }
                opponentBeingAttack = determinedOp.getOpponentId();
            } catch (NullPointerException e) {
                System.out.println("Opponent not found! Please select a valid opponent.");
                return determineOpponent(oplist); //calls the function again.
            }
            return determinedOp;
        }

       //This is also a displayer method
        public void printTurnResults(Human human, int hmndamage) {

            int damage = hmndamage;

            System.out.println(human.getName() + "  attacks " + "Opponent" + opponentBeingAttack + " deals " + damage + " damage ");
        }
    }

    //Our initailizer class
    public class Initializer {
        //This creates the queue that contains turns.
        public Queue<Turn> createQueue(ArrayList<Opponent> oplist, ArrayList<Human> humlist) {
            Queue<Turn> queue = new LinkedList<>();
            ArrayList<Member> anonimList = new ArrayList<>();
            anonimList.addAll(oplist);
            anonimList.addAll(humlist);

            int count = -1;
            int index = 0;
            Member maxMember = anonimList.get(0);
            while (!anonimList.isEmpty()) {

                for (Member member : anonimList) {

                    count++;
                    if (member.getSpeed() >= maxMember.getSpeed()) {
                        maxMember = member;
                        index = count;
                    }

                }
                count = -1;
                queue.add(new Turn(maxMember.getIdOrName()));
                anonimList.remove(index);
                if (!anonimList.isEmpty()) {
                    maxMember = anonimList.get(0);
                }
            }

            return queue;
        }

        //randomly inıtializing opponents and creating an arraylist which consist of our opponents.
        public ArrayList<Opponent> createOpponents() {

            ArrayList<Opponent> opponentList = new ArrayList<>();
            Random random = new Random();
            int numberOfOpponents = random.nextInt(1, 5); //1 to 4

            for (int i = 0; i < numberOfOpponents; i++) {
                int typeOfOpponent = random.nextInt(4);
                switch (typeOfOpponent) {
                    case 0:
                        Goblin goblin = new Goblin(i + 1);

                        opponentList.add(goblin);
                        break;
                    case 1:
                        Slime slime = new Slime(i + 1);

                        opponentList.add(slime);
                        break;
                    case 2:
                        Orc orc = new Orc(i + 1);

                        opponentList.add(orc);
                        break;
                    case 3:
                        Wolf wolf = new Wolf(i + 1);

                        opponentList.add(wolf);
                        break;
                }
            }
            return opponentList;
        }

        //This method randomly initalizes weapons also assigning additionalAttack.
        public Weapon giveWeapon() {

            int randomType;
            Random random = new Random();
            randomType = random.nextInt(0, 3);
            Random addAP = new Random();
            int additionalAttack = addAP.nextInt(10, 21);
            Weapon[] WeaponList = new Weapon[1];
            switch (randomType) {
                case 0:
                    Sword sword = new Sword();
                    sword.setAdditionalAttack(additionalAttack);
                    WeaponList[0] = sword;
                    break;
                case 1:
                    Spear spear = new Spear();
                    spear.setAdditionalAttack(additionalAttack);
                    WeaponList[0] = spear;
                    break;
                case 2:
                    Bow bow = new Bow();
                    bow.setAdditionalAttack(additionalAttack);
                    WeaponList[0] = bow;
                    break;

            }
            return WeaponList[0];
        }

        //This is where we get user inputs and generating humans
        public ArrayList<Human> createHumans() {
            ArrayList<Human> humanArrayList = new ArrayList<>();
            ArrayList<String> namesArrayList = new ArrayList<>();
            int randomType;
            String charName;
            System.out.println("Enter number of humans: ");
            int input = userIntegerInput();

            while (input > 4) {
                System.out.println("You can't have more than 3 person!");
                System.out.println("Please enter a valid integer value: ");
                input = userIntegerInput();
            }
            for (int i = 0; i < input; i++) {

                Random random = new Random();
                randomType = random.nextInt(0, 4);
                Scanner scanner = new Scanner(System.in);
                //used our custom exception in a while loop
                while (true) {
                    try {
                        System.out.println("Enter name for your"+ (i + 1)+ "." +"character " +  " ");
                        charName = scanner.nextLine();
                        if (namesArrayList.contains(charName)) {
                            throw new NotAUniqueNameException();
                        } else {
                            namesArrayList.add(charName);
                            break;
                        }
                    } catch (NotAUniqueNameException e) {
                        System.out.println("This name already exists!");
                        System.out.println("Please enter a name that is not entered before.");
                    }
                }

                switch (randomType) {
                    case 0:
                        Hunter hunter = new Hunter(charName);
                        hunter.setName(charName);
                        hunter.setWeapon(giveWeapon());
                        humanArrayList.add(hunter);
                        System.out.println("The stats of your " + (i + 1) + "." + " character" + " \n "  + hunter.toString());
                        break;
                    case 1:
                        Knight knight = new Knight(charName);
                        knight.setName(charName);
                        knight.setWeapon(giveWeapon());
                        humanArrayList.add(knight);
                        System.out.println("The stats of your " + (i + 1) + "." + " character" + " \n "   + knight.toString());
                        break;
                    case 2:
                        Squire squire = new Squire(charName);
                        squire.setName(charName);
                        squire.setWeapon(giveWeapon());
                        humanArrayList.add(squire);
                        System.out.println("The stats of your " + (i + 1) + "." + " character" + " \n "   + squire.toString());
                        break;
                    case 3:
                        Villager villager = new Villager(charName);
                        villager.setName(charName);
                        villager.setWeapon(giveWeapon()); //this method should not get initialized
                        humanArrayList.add(villager);
                        System.out.println("The stats of your " + (i + 1) + "." + " character" + " \n "   + villager.toString());
                        break;
                }
                System.out.println();
            }
            return humanArrayList;
        }

    }

    //This method is for determining who is attacking who
    public void whoAttacked(Member member) {

        if (member.getGeneralType().equals("opponent")) {
            Opponent opponent = (Opponent) member;
            if (opponent.getPoint() > 0) {

                int damage = opponentAttacking((Opponent) member);
                opponentTurn((Opponent) member, damage);
            } else {
                opponent.died();
            }
        }
        else if (member.getGeneralType().equals("human")) {
            Human human = (Human) member;
            if (human.getPoint() > 0 && human.getStamina()>0) {

                int damage = humanAttacking(member);
                System.out.println("damagge "+damage);

                menu.printTurnResults((Human) member, damage);
            }else if(human.getPoint() > 0){

            }
            else {
                human.died();
            }
        } else {
            System.out.println("member no match");
        }


    }

    public int opponentAttacking(Opponent member) {
        int opAttackSelection;
        int beforeHealty;
        int afterHealty;
        Random random = new Random();
        opAttackSelection = random.nextInt(1, 4);
        switch (opAttackSelection) {
            case 1:
                //Normal Opponent Attack
                System.out.println("Opponent used normal attack");
                Human human = humanBeingAttacked();
                beforeHealty = human.getPoint();
                member.attack(human, queue.peek().getAttackModifier());
                afterHealty = human.getPoint();
                return beforeHealty - afterHealty;

            case 2:
                //Opponent is taking guard
                System.out.println(" Opponent used guard");
                menu.humanBeingAttack = "Guarded, no attack";
                member.guard();

                return 0;

            case 3:
                //Opponent using its special attack
                System.out.println("Opponent used Special attack");
                Human human1 = humanBeingAttacked();
                beforeHealty = human1.getPoint();
                member.specialAttack(humanBeingAttacked(), queue.peek());
                afterHealty = human1.getPoint();
                return beforeHealty - afterHealty;

        }


        return 0;
    }

    //It determines randomly which human the opponent is attacking
    public Human humanBeingAttacked() {
        ArrayList<Human> currentList = humanArrayList;
        int bound = currentList.size();
        Random random = new Random();
        int randomNumber = random.nextInt(bound);
        Human human = currentList.get(randomNumber);
        menu.humanBeingAttack = human.getName();
        return human;

    }



    //This is the method that takes user input for which action will be done
    public int humanSelection() {
        Scanner scanner = new Scanner(System.in);
        int humanSelect;

        while (true) {
            try {
                System.out.println("Please select your action (1-5): ");
                humanSelect = scanner.nextInt();

                if (humanSelect >= 1 && humanSelect <= 5) {
                    break; // get out of while loop
                } else {
                    System.out.println("Invalid selection! Type and enter only 1-5 to select action");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }

        return humanSelect;
    }

    //This is for when the Stamina is low and exceptions are handled
    public int limitedHumanSelection() {
        Scanner scanner = new Scanner(System.in);
        int humanSelect;

        while (true) {
            try {
                System.out.println("Your stamina is 0. Please select your action (4-5): ");
                humanSelect = scanner.nextInt();

                if (humanSelect == 3 && humanSelect == 5) {
                    break; // get out of while loop
                } else {
                    System.out.println("Invalid selection! Type and enter only 1-5 to select action");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }

        return humanSelect;
    }


    //This method displays attack info of the current turn
    public void opponentTurn(Opponent opponent, int damage) {
        System.out.println("Opponent turn\n");
        System.out.println("Opponent" + opponent.getOpponentId() + " attacks to Human " + menu.humanBeingAttack + "  and deals damage: " + damage);
    }

    //This method is for managing human attacks also handling the Stamina Exception
    public int humanAttacking(Member member) {
        Human hmn = (Human) member;
        int userInput = 0;
        int temp = 0;
        menu.humanChoiceMenu();
        if (queue.peek().getAttackModifier() == 1) {

            if (hmn.getStamina() <= 0) {
                try {
                    throw new InsufficientStaminaException("Stamina is insufficient");
                } catch (InsufficientStaminaException e) {
                    temp = limitedHumanSelection();
                }

            } else {
                temp = humanSelection();
            }

            userInput = temp;


            if (userInput == 1) {

                Opponent opponent = menu.determineOpponent(opponentArraytList);


                int punchdanonce = opponent.getPoint();
                hmn.punch(opponent, queue.peek());
                int punchdansonra = opponent.getPoint();
                return punchdanonce - punchdansonra;
            } else if (userInput == 2) {

                System.out.println(queue.peek().getOwnerIdOrName());
                if (hmn instanceof Human) {


                    if (hmn instanceof Hunter) {
                        Hunter hunter = (Hunter) hmn;
                        Opponent opponent = menu.determineOpponent(opponentArraytList);
                        System.out.println("Hunter attack point" + hunter.getAttack());
                        System.out.println("Weapon attack point" + hunter.getWeapon().getAdditionalAttack());
                        int pointsBefore = opponent.getPoint();
                        System.out.println("Opponent Point" + opponent.getPoint());
                        hunter.attackWithWeapon(opponent, queue.peek().getAttackModifier(), menu.weaponSpecialAttackTypeSelection(hunter));
                        System.out.println("Before " + opponent.getPoint());
                        int pointsAfter = opponent.getPoint();
                        System.out.println("hunter attack");
                        return pointsAfter - pointsBefore;
                    } else if (hmn instanceof Knight) {
                        Knight knight = (Knight) hmn;
                        Opponent opponent = menu.determineOpponent(opponentArraytList);
                        System.out.println("hunterın atak gücü" + knight.getAttack());
                        System.out.println("weapon  gücü" + knight.getWeapon().getAdditionalAttack());
                        int pointsBefore = opponent.getPoint();
                        System.out.println("op can" + opponent.getPoint());
                        knight.attackWithWeapon(opponent, queue.peek().getAttackModifier(), menu.weaponSpecialAttackTypeSelection(knight));
                        System.out.println("opun sonraki canı" + opponent.getPoint());
                        opponent.getPoint();
                        int pointsAfter = opponent.getPoint();
                        System.out.println("knight attack yapıyor");
                        return pointsBefore - pointsAfter;
                    } else if (hmn instanceof Villager) {

                        Villager villager = (Villager) hmn;
                        Opponent opponent = menu.determineOpponent(opponentArraytList);
                        System.out.println("hunterın atak gücü" + villager.getAttack());
                        System.out.println(villager.getWeapon().getAdditionalAttack());
                        int pointsBefore = opponent.getPoint();
                        System.out.println("op can" + opponent.getPoint());
                        villager.attackWithWeapon(opponent, queue.peek().getAttackModifier(), menu.weaponSpecialAttackTypeSelection(villager));
                        System.out.println(opponent.getPoint());
                        int pointsAfter = opponent.getPoint();
                        System.out.println("villager attack");
                        return pointsBefore - pointsAfter;
                    } else if (hmn instanceof Squire) {

                        Squire squire = (Squire) hmn;
                        Opponent opponent = menu.determineOpponent(opponentArraytList);
                        System.out.println("hunterın atak gücü" + squire.getAttack());
                        int pointsBefore = opponent.getPoint();
                        System.out.println(squire.getWeapon().getAdditionalAttack());
                        System.out.println("op can" + opponent.getPoint());
                        squire.attackWithWeapon(opponent, queue.peek().getAttackModifier(), menu.weaponSpecialAttackTypeSelection(squire));
                        System.out.println(opponent.getPoint());
                        int pointsAfter = opponent.getPoint();
                        System.out.println("squire attack");
                        return pointsBefore - pointsAfter;
                    }
                }
            } else if (userInput == 3) {
                hmn.guard();
                System.out.println("human guard alıyor");

            } else if (userInput == 4) {
                Human human = (Human) member;
                Opponent opponent = menu.determineOpponent(opponentArraytList);
                int pointsBefore = opponent.getPoint();
                System.out.println(pointsBefore);
                System.out.println("quee peek"+queue.peek().getOwnerIdOrName());
                human.specialAction(opponent, queue.peek());
                int pointsAfter = opponent.getPoint();
                System.out.println(pointsAfter);
                return pointsBefore - pointsAfter;
            }else if(userInput==5){
                System.out.println("Your character(s) started running away. The battle ends!\n" +
                        "Thanks for playing!");
                System.exit(5);
            }

            return 0;
        } else {
            Opponent opponent = menu.determineOpponent(opponentArraytList);
            int pointsBefore = opponent.getPoint();
            hmn.modifierAttack(opponent,queue.peek());
            int pointsAfter = opponent.getPoint();
            queue.peek().setAttackModifier(1);

            return pointsBefore - pointsAfter;
        }

    }

    //This method manages attacks in general and act as a composite method like a
    //general management method.
    public void attackController() {
        Scanner scanner = new Scanner(System.in);
        boolean containHuman = true;
        int humanCounter = 0;
        int opponentCounter=0;
        while (containHuman) {
            humanCounter = 0;
            opponentCounter=0;
           
            
            System.out.print("\nTurnOrder: \n");

            if(menu.findTurnMember(queue.peek(),opponentArraytList,humanArrayList).getGeneralType().equals("human")){
                for(int i =0;i<humanArrayList.size();i++){
                    System.out.print(humanArrayList.get(i).toString());
                }
                for(int j =0;j<opponentArraytList.size();j++){
                    System.out.print(opponentArraytList.get(j).toString());
                }
            }
            for (Turn element : queue
            ) {
                ;

                System.out.print(" "+element.getOwnerIdOrName()+", ");
                Member member = menu.findTurnMember(element, opponentArraytList, humanArrayList);

                if (member instanceof Human<?>) {
                    
                    humanCounter++;
                }
                if (member instanceof Opponent) {
                    opponentCounter++;
                }
            }
            System.out.println("");
            System.out.println("");
            Turn turn = queue.peek();
            Member member = menu.findTurnMember(turn, opponentArraytList, humanArrayList);
            whoAttacked(member);
            queue.remove();
            if (!member.isDead()) {
                queue.add(turn);
            }else {
                if (member instanceof Human<?>) {
                humanArrayList.remove(member);
            }else{opponentArraytList.remove(member);}

            }


            if (humanCounter == 0) {
                containHuman = false;

            }if (opponentCounter == 0) {
                containHuman = false;
                System.out.println("You won!");
            System.out.println("+++++++++++++++++++++++++++++++++++++\n");
        }


        }
    }
}


