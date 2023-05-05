import java.util.Scanner;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class FileArranger {
    public static void cls() {
        System.out.print("\033\143");

    }

    public static void logo() {
        System.out.println("   _____ __    ___                                 \n" +
                "  / __(_) /__ / _ | ___________ ____  ___ ____ ____\n" +
                " / _// / / -_) __ |/ __/ __/ _ `/ _ \\/ _ `/ -_) __/\n" +
                "/_/ /_/_/\\__/_/ |_/_/ /_/  \\_,_/_//_/\\_, /\\__/_/   \n" +
                "                                    /___/          ");
    }

    public static void check_path(String pa) {
        Path fun_path = Paths.get(pa);
        if (!Files.exists(fun_path)) {
            System.out.println("This path does not exist");
            System.exit(0);
        }
    }

    public static String get_folderPath() {
        Scanner second_input = new Scanner(System.in);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cls();
        logo();
        System.out.print("Please enter  the folder path to put all the given extension files \n[>>]");
        second_input.nextLine();  // to prevent scanner eating next input
        String folder_path = second_input.nextLine();
        check_path(folder_path);
        System.out.println("This folder is selected " + folder_path);
        return folder_path;
    }
        public static void CD(String fp) {
        try {
            Path create_dir = Paths.get(fp);
            Files.createDirectories(create_dir);
            System.out.println("This directory has been created");
        } catch (Exception e) {
            System.out.println("Cannot create a directory ,error occuored");
            System.exit(0);
        }

        }




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args){
        cls();
        logo();

        System.out.print("This script will help you manage your file");
        System.out.println(" By putting the files in the directory  in their designated folders");
        System.out.println("Please enter the file path you want to arrange");
        System.out.print("[>>]");

        Scanner input=new Scanner(System.in);
        String c1=input.nextLine();
        Path main_path=Paths.get(c1);
        if (!Files.exists(main_path)){
            System.out.println("Your path does not exists,Please try another path ");
            System.exit(0);
        }
        System.out.println("Copying your path  "+c1);
         try{
        Thread.sleep(2000);

         }
         catch (Exception e ){
             System.out.println(e);

         }
         cls();
         logo();
        while(true) {
            HashMap<String,String[]> dict=new HashMap<>();
            System.out.println("Please,enter the extensions of your folder  that you want us to use  ,as weill organise  file based upon their extensions ");
            System.out.print("In this  format  like for  video player extensions[.mkv,.mp4,.avi,.flv ]");
            System.out.print("[>>]");
//            input.nextLine();  // to prevent scanner eating next input

            String raw_extensions = input.nextLine();
            String[] extensions = raw_extensions.split(",");

            System.out.println("Do you want to choose procreated  folder for these extensions   or create a new folder ");
            System.out.println("[1]Use  procreated folder/Give path of your  folders \n[2]To create new folders ");
            System.out.print("[>>]");
            int c2 = input.nextInt();
            System.out.println(c2);
            if (c2 == 1) {
                System.out.println("Right then we will use precreated folders");
                dict.put(get_folderPath(),extensions);
                System.out.println(dict);
                System.out.print("[1]Do you want to select another  or [2]continue\n[>>]");

                int c4= input.nextInt();
                if (c4==1){
                    continue;
                } else if (c4==2) {
                    break;

                }
                else {
                    System.out.println("Wrong Input ");
                    try{
                    Thread.sleep(2000);
                    }catch(Exception e){
                        throw new RuntimeException(e);

                    }
                    System.exit(0);
                }
            } else if (c2 == 2) {
                System.out.println("Right then we will create new folder");
                CD(get_folderPath());

            } else {
                System.exit(0);
            }


        }
    }
}