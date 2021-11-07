package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CFGRead {


    public static ArrayList<String> readFile(String file) throws IOException{
        BufferedReader in;
        in = new BufferedReader(new FileReader(file));
        String str = in.readLine();
        ArrayList<String> relevantInfo = new ArrayList<String>();
        while (str != null) {
            if (str.equals("") || str.charAt(0) == '#') {
                str = in.readLine();
                continue;
            }
            relevantInfo.add(str.split("= ")[1]);
            str = in.readLine();
        }
        in.close();
        return relevantInfo;
    }
    public static ArrayList<DeviceProp> readEntitysettings() throws IOException{
        ArrayList<DeviceProp> deviceListSettings = new ArrayList<DeviceProp>();
        ArrayList<String> relevantInfo;
        relevantInfo = readFile("config/entitysettings.cfg");
        int step = 0;

        String name = "";
        double power=0;
        int w_sch_id=0;
        int m_sch_id=0;
        double multiplier=0;
        for (String str : relevantInfo) {
            switch (step) {
            case 0:
            
                name = str;
                step++;
                break;
            case 1 :
                power = Double.parseDouble(str);
                step++;
                break;
            case 2 :
                w_sch_id = Integer.parseInt(str);
                step++;
                break;
            case 3 :
                m_sch_id = Integer.parseInt(str);
                step++;
                break;
            case 4 :
                multiplier = Double.parseDouble(str);  
                step = 0;
                deviceListSettings.add(new DeviceProp(name, power, w_sch_id, m_sch_id, multiplier));
                break;
            default:
                break;
            }
        }
        return deviceListSettings;

    }
  
    public static void main(String[] args) throws IOException {
        ArrayList<DeviceProp> devlist = readEntitysettings();
        System.out.println(devlist);
    }
}

