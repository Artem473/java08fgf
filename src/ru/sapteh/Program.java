package ru.sapteh;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Program {
    public static void main(String[] args) throws IOException, SQLException {


        Database database = new Database();

        Connection connection = database.getConnect();

        String sql = "SELECT * FROM auto_table";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Auto> autos = new ArrayList<>();

        if (args.length == 0){
            return;
        }

        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String marka = resultSet.getString(2);
            String model = resultSet.getString(3);
            String proizvoditel = resultSet.getString(4);
            String years = resultSet.getString(5);
            String color = resultSet.getString(6);
            Auto auto = new Auto(id,marka,model,proizvoditel,years,color);
            autos.add(auto);
        }

        try(FileWriter fileWriter = new FileWriter("auto_List.txt")){
            for (Auto auto : autos){
                fileWriter.write(auto.toString());
                fileWriter.write("\n");
            }
        }

        for(Auto auto : autos){
            System.out.println(auto.toString());
        }

//        if ("-c".equals(args[0])){
//            String sql1 = "INSERT INTO auto_table(marka, model, proizvoditel, years, color) VALUES (?,?,?,?,?)";
//            PreparedStatement statement1 = connection.prepareStatement(sql1);
//            statement1.setString(1, args[1].trim());
//            statement1.setString(2, args[2].trim());
//            statement1.setString(3, args[3].trim());
//            statement1.setString(4, args[4].trim());
//            statement1.setString(5, args[5].trim());
//            int res = statement1.executeUpdate();
//            System.out.println(res);
//
////            ResultSet genKey = statement.getGeneratedKeys();
////            int id = 0;
////            if(genKey.next()){
////                id = genKey.getInt(1);
////            }
//
//        }

        if ("-d".equals(args[0])){
            String del = "DELETE FROM auto_table WHERE id = ?";
            PreparedStatement statement2 = connection.prepareStatement(del);
            statement2.setString(1,args[1]);
            statement2.executeUpdate();
        }
        database.closeConnect(connection);
    }

}
