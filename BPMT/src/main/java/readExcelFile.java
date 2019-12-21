/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Denizcan
 */
public class readExcelFile {

    public static ArrayList<ArrayList<String>> read(File file) throws FileNotFoundException, IOException {
        ArrayList<ArrayList<String>> items = new ArrayList<ArrayList<String>>();

        try (InputStream inp = new FileInputStream(file.getAbsolutePath())) {

            Workbook wb = WorkbookFactory.create(inp);

            for (org.apache.poi.ss.usermodel.Sheet s : wb) {
                System.out.println(s.getSheetName());
            }
            Sheet sheet = wb.getSheetAt(0);

            int rows = sheet.getLastRowNum();
            for(int i = 1;i<rows;++i){
                Row row = sheet.getRow(i);
                ArrayList<String> tmp = new ArrayList<>();
                for(Cell cell :row){
                    tmp.add(cell.toString());
                }
                items.add(tmp);
            }
        }
        return items;
    }
    public static void insertToDB(File file){
        int startID = SQLUtilities.currenid(Frame.conn)+1;
        
        try {
            var items = read(file);
            SQLUtilities.AddItemBatch(items,startID);
            SQLUtilities.uploadImageWithStartID(items, startID);
            try {
                Frame.conn.commit();
            } catch (SQLException ex) {
                Logger.getLogger(readExcelFile.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        } catch (IOException ex) {
            Logger.getLogger(readExcelFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
