import java.sql.*;
import java.util.*;

class prototype{
    public static void main(String[] args) {
        // Database link and credentials
    String DB_URL="jdbc:mysql://localhost:3306/"; // MySQL localhost connection using JDBC 
    String DB_NAME="test"; // Database name
    String USER="root"; // Username
    String PASS=""; // Password
    // App variables
    Scanner input = new Scanner(System.in);
    int user= 1;
    int ask=0;
    int num_of_students=0;
    double grades=0;   
    double average=0;
    double total=0;
    String username = "";
    String password="";
    String sql = "";
    // Using try catch to verify if our program is connected to database
    try{
         // Create a connection to XAMPP database using the credentials given above 
        Class.forName("com.mysql.jdbc.Driver");
         Connection conn=DriverManager.getConnection(DB_URL + DB_NAME, USER, PASS); 
        // This line of code accepts commands/statements from this Java
        // program to the database and returns its results.
        // Statement stat=conn.createStatement();
        // Start of usual Java program
        System.out.println("Prototype OOP, Database, & IT Project Management Collab Program "); 
        System.out.println("Database connected...\n");
        System.out.println("Press 1 to start press 0 to exit"); 
        ask=Integer.parseInt(input.nextLine());
        System.out.print("");
        while(ask==1){
            System.out.println("Dashboard \n1. Login\n2. Register\n3"); 
            System.out.print(">>>");
            user=Integer.parseInt(input.nextLine());
            System.out.print("");
            if(user==1){
                System.out.println("Login -----");
                System.out.print("Enter username: "); 
                username=input.nextLine();
                System.out.print("");
                System.out.print("Enter password: "); 
                password= input.nextLine();
                System.out.print("");
                sql="Select * from tblogin where userr=? and password=?";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet rs= preparedStatement.executeQuery();
                if(rs.next()){
                    System.out.println("Successfully logged in..."); 
                    System.out.println("Welcome");
                    System.out.println("");
                    System.out.println("Enter the total number of students: ");
                    num_of_students=input.nextInt();
                    for(int x=1; x<num_of_students+1; x++){
                        System.out.println("Enter grade for student "+x+": ");
                        grades=input.nextDouble();
                        total+=grades;
                        average=total/num_of_students;
                    }System.out.println("Total number of students: "+num_of_students);
                    System.out.println("Class average: "+average);                   
                                      
                    }else{
                        System.out.println("Username not found!");
                    }
                rs.close();
            }else if(user==2){
                System.out.println("Register....");
                System.out.print("Enter username: ");
                username= input.nextLine();
                System.out.print("");
                System.out.print("Enter password: ");
                password=input.nextLine();
                System.out.print("");
                sql = "INSERT INTO tblogin(userr, password) VALUES(?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                preparedStatement.executeUpdate();
                System.out.println("Registration done!\n");
            }
             
             
        }
        ///
       
        

    }catch(Exception e){
        System.out.println(e);
    }input.close();
    
    

}
}
       
    
       