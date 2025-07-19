import java.util.Scanner;


public class Main {
    static int numberElements=0;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String[] namesList= new String[20];
        boolean wishKeep=true;
        int choose;
        String enterName;
        while(wishKeep){
            printMenu();

            choose=scanner.nextInt();
            scanner.nextLine();//fix a bug
            switch (choose){
                case 1:
                    System.out.println("Enter the name to will be recorder at the  name list");
                    enterName=scanner.nextLine();
                    recorderToList(namesList,enterName);
                    break;
                case 2:
                    printList(namesList);
                    break;
                case 3:
                    System.out.println("Enter the name to will be searched at the name list");
                    enterName= scanner.nextLine();
                    if(binarySearch(enterName,namesList)==true){
                        System.out.println("This name exist on the list");
                    }else{
                        System.out.println("This name don't exist");
                    }
                    break;
                default:
                    System.out.println("Bye, bye....");
                    wishKeep=false;

            }
        }
    }

    static void printMenu(){
        System.out.println("Would you choose a option, please");
        System.out.printf(" 1-Recorder\n"+
                "2- Show recorders\n"+
                "3-Seach\n"+
                "4-Get out\n");
    }

    static void printList(String[] list){
        int index=0;
        while(list[index]!=null){
            System.out.println("index "+index+" :"+list[index]);
            index++;
        }
    }
    static void recorderToList(String[] atList, String name){
        if(isRepeatedName(name,atList)){
            System.out.println("This name can not recorder,because" +
                    "already exist a people with the same name at list");
        }else{
            register(name,atList);
        }

    }

    static void register(String name, String[] list){
        list[numberElements]=name;
        numberElements++;
        sortList(list);
    }

    static void sortList(String[] list){
        String aux;
        for(int i=0;i<numberElements;i++){
            for(int j=0; j<numberElements; j++){
                if(list[i].compareTo(list[j])<0){
                    aux=list[i];
                    list[i]=list[j];
                    list[j]=aux;
                }
            }
        }
    }

    static boolean isRepeatedName(String name, String[] atList){
        boolean isRepeatedName=false;
        for(String listName:atList){
            if(name.equalsIgnoreCase(listName))
                isRepeatedName=true;
        }
        return  isRepeatedName;
    }


    static boolean binarySearch(String name, String[] lista){
        boolean numberFinded=false;
        int back=0, front=numberElements-1, middle;
        while((back<=front)&&(!numberFinded)){
            middle=(back+front)/2;
            if(lista[middle].compareToIgnoreCase(name)<0){
                back=middle+1;
            } else if (lista[middle].compareToIgnoreCase(name)>0) {
                front=middle-1;
            }else{
                numberFinded=true;
            }
        }
        return numberFinded;
    }

}