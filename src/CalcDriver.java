import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;

/**
 * Calculator for Binary, Hexadecimal, and various other calculations
 * @author Winston Palace
 * @version 1/16/21
 */
public class CalcDriver {
    /*
        Calculator functions:
        Binary - Add, Subtract, Multiply, and Divide. Convert Binary to Decimal Value.
        Hex - Add, Subtract, Multiply, and Divide. Convert Hexadecimal Value to Decimal Value.
            Convert Decimal Value to Hexadecimal Value.
        Bandwidth - Data Unit Converter, Download/Upload Time Calculator, Website Bandwidth Calculator,
            and Hosting Bandwidth Calculator.
    */

    //Currently Limited to Long sizes

    /**
     * Driver method for PRGA Calculator Project
     * @param args used for command line input
     */
    public static void main(String[] args) {
        //+~~~~~~+~~~~~~+~~~~~~~~~~~+
        //|  fg  |  bg  |  color    |
        //+~~~~~~+~~~~~~+~~~~~~~~~~~+
        //|  30  |  40  |  black    |
        //|  31  |  41  |  red      |
        //|  32  |  42  |  green    |
        //|  33  |  43  |  yellow   |
        //|  34  |  44  |  blue     |
        //|  35  |  45  |  magenta  |
        //|  36  |  46  |  cyan     |
        //|  37  |  47  |  white    |
        //|  39  |  49  |  default  |
        //+~~~~~~+~~~~~~+~~~~~~~~~~~+
        //System.out.println((char)27 + "[33mYELLOW");
        menu();
    }

    /**
     * Main Menu
     */
    public static void menu(){
        Scanner input = new Scanner(System.in);
        String instructions = "Select Your Desired Calculator: \nBinary Calculator       |1\nHexadecimal Calculator  |2\nBandwidth Calculator    |3" +
                "\nTesting:                |4\nExit:                   |5";
        System.out.println(instructions);
        boolean calcSelected = false;
        int calcSelection = 0;
        while(!calcSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            calcSelection = input.nextInt();
            if(calcSelection>0&&calcSelection<6){
                calcSelected = true;
            }
            else {
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(calcSelection==1){
            binaryMenu();
        }
        else if(calcSelection==2){
            hexadecimalMenu();
        }
        else if(calcSelection==3){
            bandwidthMenu();
        }
        else if(calcSelection==4){
            testCase();
        }
        else {
            return;
        }
        menu();
    }

    /**
     * Binary Functions Menu
     */
    public static void binaryMenu(){
        Scanner input = new Scanner(System.in);
        String instructions = "Select Your Desired Function: \nBinary to Decimal       |1\nDecimal to Binary       |2\nBinary Calculator       |3" +
                "\nBack:                   |4";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<5){
                functionSelected = true;
            }
            else {
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            System.out.println("Type a Binary String to be converted:");
            System.out.println("Converted: " + binToDecimal(input.next()));
        }
        else if(functionSelection==2){
            System.out.println("Type a Number to be converted:");
            while (!input.hasNextLong()) {
                input.next();
                System.out.println("Bad Input");
                System.out.println("Type a Number to be converted:");
            }
            System.out.println("Converted: " + toBinary(input.nextLong()));
        }
        else if(functionSelection==3){
            System.out.println("Type a Binary String to be converted in the format: \"10101+101010\", (+,-,*,/) Are acceptable");
            System.out.println("= " + binaryCalc(input.next()));
        }
        else {
            return;
        }
        binaryMenu();
    }

    /**
     * Hexadecimal Functions Menu
     */
    public static void hexadecimalMenu(){
        Scanner input = new Scanner(System.in);
        String instructions = "Select Your Desired Function: \nHexadecimal to Decimal  |1\nDecimal to Hexadecimal  |2\nHexadecimal Calculator  |3" +
                "\nBack:                   |4";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<5){
                functionSelected = true;
            }
            else {
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            System.out.println("Type a Hexadecimal String to be converted:");
            System.out.println("Converted: " + hexToDecimal(input.next()));
        }
        else if(functionSelection==2){
            System.out.println("Type a Number to be converted:");
            while (!input.hasNextLong()) {
                input.next();
                System.out.println("Bad Input");
                System.out.println("Type a Number to be converted:");
            }
            System.out.println("Converted: " + toHex(input.nextLong()));
        }
        else if(functionSelection==3){
            System.out.println("Type a Hexadecimal String to be converted in the format: \"FFFF+FFFF\", (+,-,*,/) Are acceptable");
            System.out.println("= " + hexadecimalCalc(input.next()));
        }
        else {
            return;
        }
        hexadecimalMenu();
    }

    /**
     * Bandwidth Functions Menu
     */
    public static void bandwidthMenu(){
        Scanner input = new Scanner(System.in);
        String instructions = "Select Your Desired Function: \nData Unit Converter            |1\nDownload Time Calculator       |2\nWebsite Bandwidth Calculator   |3" +
                "\nHosting Bandwidth Converter    |4"+"\nBack:                          |5";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<6){
                functionSelected = true;
            }
            else {
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            System.out.println("Enter Value: ");
            while (!input.hasNextBigDecimal()) {
                input.next();
                System.out.println("Numbers Only");
            }
            BigDecimal num = input.nextBigDecimal();
            String unit = fileUnitSelect();
            System.out.println(dataUnitConvert(num,unit,"") + " Terrabytes (TB)");
            System.out.println();
        }
        else if(functionSelection==2){
            System.out.println("Enter File Size Value: ");
            while (!input.hasNextBigInteger()) {
                input.next();
                System.out.println("Numbers Only");
            }
            BigInteger fileSize = input.nextBigInteger();
            String fileUnit = fileUnitSelect();
            System.out.println("Enter Bandwidth Value: ");
            while (!input.hasNextBigDecimal()) {
                input.next();
                System.out.println("Numbers Only");
            }
            BigInteger bandSize = input.nextBigInteger();
            String bandUnit = fileUnitSelect();
            //System.out.println(fileSize+fileUnit+" "+bandSize+bandUnit);
            System.out.println(downloadTimeCalc(fileSize,fileUnit,bandSize,bandUnit));
        }
        else if(functionSelection==3){
            System.out.println("Enter Page Views Per Day: ");
            while (!input.hasNextDouble()) {
                input.next();
                System.out.println("Numbers Only");
            }
            Double pageViews = input.nextDouble();
            System.out.println("Enter Average Page Size: ");
            while (!input.hasNextLong()) {
                input.next();
                System.out.println("Numbers Only");
            }
            long avgPgSize = input.nextLong();
            String pgSizeUnit = fileUnitSelect();
            System.out.println("Enter Redundancy Factor: ");
            while (!input.hasNextBigDecimal()) {
                input.next();
                System.out.println("Numbers Only");
            }
            double redunF = input.nextDouble();
            websiteBandwidthCalc(pageViews,1,avgPgSize,pgSizeUnit,redunF);

        }
        else if(functionSelection==4){

        }
        else {
            return;
        }
        bandwidthMenu();
    }

    /**
     * Selects the Data Unit from User Input
     * @return Returns the desired Data Unit5
     */
    public static String fileUnitSelect(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select Unit Type:");
        String instructions = "bits      |1\nkilobits  |2\nmegabits  |3\ngigabits  |4\nterabits  |5\nBytes     |6\nKilobytes |7\nMegabytes |8\n" +
                "Gigabytes |9\nTerabytes |10";
        System.out.println(instructions);
        boolean functionSelected = false;
        int functionSelection = 0;
        while(!functionSelected) {
            while (!input.hasNextInt()) {
                input.next();
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
            functionSelection = input.nextInt();
            if(functionSelection>0&&functionSelection<11){
                functionSelected = true;
            }
            else {
                System.out.println("Bad Input");
                System.out.println(instructions);
            }
        }
        if(functionSelection==1){
            return "b";
        }
        else if(functionSelection==2){
            return "kb";
        }
        else if(functionSelection==3){
            return "mb";
        }
        else if(functionSelection==4){
            return "gb";
        }
        else if(functionSelection==5){
            return "tb";
        }
        else if(functionSelection==6){
            return "B";
        }
        else if(functionSelection==7){
            return "KB";
        }
        else if(functionSelection==8){
            return "MB";
        }
        else if(functionSelection==9){
            return "GB";
        }
        else {
            return "TB";
        }
    }

    /**
     * Converts a Long to a Binary Sequence up to approaching the Long Max Value
     * @param number Long number for translation
     * @return Returns the decimal as binary
     */
    public static String toBinary(Long number) {
        // 256 128 64 32 16 4 2 u
        StringBuilder bin = new StringBuilder();
        if(number<0){
            bin.append("-");
            number = Math.abs(number);
        }
        int nearPw = 0;
        for(int y=1;Math.pow(2,y)<=number;y++){
            nearPw = y;
        }
        for(int i=nearPw;i>=0;i--){
            if(number>=Math.pow(2,i)){
                bin.append("1");
                number -= (long)Math.pow(2,i);
            }
            else {
                bin.append("0");
            }
        }
        return bin.toString();
        /*
        //BigInteger Attempt for Future Implementation, also needs negative cases
        // 256 128 64 32 16 4 2 u
        StringBuilder bin = new StringBuilder();
        int nearPw = 0;
        for(int y=1;0>BigInteger.valueOf(2).pow(y).compareTo(number);y++){
            nearPw = y;
        }
        //System.out.println(nearPw);
        for(int i=nearPw;i>=0;i--){
            if(0>=BigInteger.valueOf(2).pow(i).compareTo(number)){
                bin.append("1");
                number = number.subtract(BigInteger.valueOf(2).pow(i));
            }
            else {
                bin.append("0");
            }
         return bin.toString();
         */
    }

    /**
     * Converts a Binary String to a Decimal Long
     * @param binaryString Binary String for Translation
     * @return Returns the binary as a decimal
     */
    public static Long binToDecimal(String binaryString){
        StringBuilder bin = new StringBuilder();
        long number = 0;
        String[] sepList = binaryString.split("");
        for(int i=binaryString.length()-1;i>=0;i--){
            bin.append(sepList[i]);
        }
        sepList = bin.toString().split("");
        if(sepList[0].equals("1")){
            number++;
        }
        for(int x=1;x<sepList.length;x++){
            if(sepList[x].equals("1")){
                number+=Math.pow(2,x);
            }
        }
        return number;
    }

    /**
     * Does Addition, Subtraction, Multiplication, and Division with a Binary String in the format "1001+101010"
     * @param binaryString Binary String with an operator (+,-,*,%) for calculations
     * @return Returns the calculated binary numbers
     */
    public static Long binaryCalc(String binaryString){
        binaryString = binaryString.replaceAll("\\s", "");
        String[] sepList;
        long num;
        if(binaryString.contains("+")){
            sepList = binaryString.split("\\+");
            num = binToDecimal(sepList[0])+ binToDecimal(sepList[1]);
        }
        else if(binaryString.contains("-")){
            sepList = binaryString.split("-");
            num = binToDecimal(sepList[0])- binToDecimal(sepList[1]);
        }
        else if(binaryString.contains("*")){
            sepList = binaryString.split("\\*");
            num = binToDecimal(sepList[0])* binToDecimal(sepList[1]);
        }
        else if(binaryString.contains("/")){
            sepList = binaryString.split("/");
            num = binToDecimal(sepList[0])/ binToDecimal(sepList[1]);
        }
        else {
            System.out.println("Either does not have a modifier or contains unknown characters");
            return -1L;
        }
        return num;
    }

    /**
     * Converts a Long to a Hexadecimal Sequence up to approaching the Long Max Value
     * @param number Long number for translation
     * @return Returns the deciaml as a hexadeciaml
     */
    public static String toHex(long number){
        StringBuilder hex = new StringBuilder();
        int nearPw = 0;
        if(number<0){
            hex.append("-");
            number = Math.abs(number);
        }
        for(int y=1;Math.pow(16,y)<=number;y++){
            nearPw = y;
        }
        for(int i=nearPw;i>=0;i--){
            if(number>=Math.pow(16,i)*15){
                hex.append("F");
                number -= Math.pow(16,i)*15;
            }
            else if(number>=Math.pow(16,i)*14){
                hex.append("E");
                number -= Math.pow(16,i)*14;
            }
            else if(number>=Math.pow(16,i)*13){
                hex.append("D");
                number -= Math.pow(16,i)*13;
            }
            else if(number>=Math.pow(16,i)*12){
                hex.append("C");
                number -= Math.pow(16,i)*12;
            }
            else if(number>=Math.pow(16,i)*11){
                hex.append("B");
                number -= Math.pow(16,i)*11;
            }
            else if(number>=Math.pow(16,i)*10){
                hex.append("A");
                number -= Math.pow(16,i)*10;
            }
            else if(number>=Math.pow(16,i)*9){
                hex.append("9");
                number -= Math.pow(16,i)*9;
            }
            else if(number>=Math.pow(16,i)*8){
                hex.append("8");
                number -= Math.pow(16,i)*8;
            }
            else if(number>=Math.pow(16,i)*7){
                hex.append("7");
                number -= Math.pow(16,i)*7;
            }
            else if(number>=Math.pow(16,i)*6){
                hex.append("6");
                number -= Math.pow(16,i)*6;
            }
            else if(number>=Math.pow(16,i)*5){
                hex.append("5");
                number -= Math.pow(16,i)*5;
            }
            else if(number>=Math.pow(16,i)*4){
                hex.append("4");
                number -= Math.pow(16,i)*4;
            }
            else if(number>=Math.pow(16,i)*3){
                hex.append("3");
                number -= Math.pow(16,i)*3;
            }
            else if(number>=Math.pow(16,i)*2){
                hex.append("2");
                number -= Math.pow(16,i)*2;
            }
            else if(number>=Math.pow(16,i)*1){
                hex.append("1");
                number -= Math.pow(16,i)*1;
            }
            else {
                hex.append("0");
            }
        }
        return hex.toString();
    }

    /**
     * Converts a Hexadecimal String to a Decimal Long
     * @param hexString Hexadecimal String for Translation
     * @return Returns the hexadecimal as a decimal
     */
    public static Long hexToDecimal(String hexString){
        long num = 0;
        String[] hexList = hexString.split("");
        int x = 0;
        for(String y: hexList){
            /*if(!y.equals("0")||!y.equals("1")||!y.equals("2")||!y.equals("3")||!y.equals("4")||!y.equals("5")||
                    !y.equals("6")||!y.equals("7")||!y.equals("8")||!y.equals("9")|| !y.toLowerCase().equals("a")||
                    !y.toLowerCase().equals("b")||!y.toLowerCase().equals("c") ||!y.toLowerCase().equals("d")||
                    !y.toLowerCase().equals("e")||!y.toLowerCase().equals("f")||!y.toLowerCase().equals("")){
                return 0L;
            }
             */
            String temp = y.toLowerCase();
            if(temp.contains("0")||temp.contains("1")||temp.contains("3")||temp.contains("4")||temp.contains("5")||temp.contains("6")
                    ||temp.contains("7")||temp.contains("8")||temp.contains("9")||temp.contains("a")||temp.contains("b")
                    ||temp.contains("c")||temp.contains("d")||temp.contains("e")||temp.contains("f")){
            }
            else {
                return 0L;
            }
        }
        for(int i=hexList.length-1;i>=0;i--){
            if(hexList[i].equalsIgnoreCase("a")){
                hexList[i] = "10";
            }
            else if(hexList[i].equalsIgnoreCase("b")){
                hexList[i] = "11";
            }
            else if(hexList[i].equalsIgnoreCase("c")){
                hexList[i] = "12";
            }
            else if(hexList[i].equalsIgnoreCase("d")){
                hexList[i] = "13";
            }
            else if(hexList[i].equalsIgnoreCase("e")){
                hexList[i] = "14";
            }
            else if(hexList[i].equalsIgnoreCase("f")){
                hexList[i] = "15";
            }
            num += Long.parseLong(hexList[i])*Math.pow(16,x);
            x++;
        }
        return num;
    }

    /**
     * Does Addition, Subtraction, Multiplication, and Division with a Hexadecimal String in the format "FFF+FFF"
     * @param hexadecimalString Hexadecimal String with an operator (+,-,*,%) for calculations
     * @return Returns the calculated hexadecimals
     */
    public static Long hexadecimalCalc(String hexadecimalString){
        hexadecimalString = hexadecimalString.replaceAll("\\s", "");
        String[] sepList;
        long num;
        if(hexadecimalString.contains("+")){
            sepList = hexadecimalString.split("\\+");
            num = hexToDecimal(sepList[0])+ hexToDecimal(sepList[1]);
        }
        else if(hexadecimalString.contains("-")){
            sepList = hexadecimalString.split("-");
            num = hexToDecimal(sepList[0])- hexToDecimal(sepList[1]);
        }
        else if(hexadecimalString.contains("*")){
            sepList = hexadecimalString.split("\\*");
            num = hexToDecimal(sepList[0])* hexToDecimal(sepList[1]);
        }
        else if(hexadecimalString.contains("/")){
            sepList = hexadecimalString.split("/");
            num = hexToDecimal(sepList[0])/ hexToDecimal(sepList[1]);
        }
        else {
            System.out.println("Either does not have a modifier or contains unknown characters");
            return -1L;
        }
        return num;
    }

    /**
     * Converts units of data
     * @param num Numerical value of data
     * @param getType Unit type of data
     * @param returnType Desired data unit
     * @return Returns a String of the converted data amount and type
     */
    public static BigDecimal dataUnitConvert(BigDecimal num, String getType, String returnType){
        if(getType.equals("kb")){
            num = num.multiply(BigDecimal.valueOf(1000L));
        }
        else if(getType.equals("mb")){
            num = num.multiply(BigDecimal.valueOf(1000L).pow(2));
        }
        else if(getType.equals("gb")){
            num = num.multiply(BigDecimal.valueOf(1000L).pow(3));
        }
        else if(getType.equals("tb")){
            num = num.multiply(BigDecimal.valueOf(1000L).pow(4));
        }
        else if(getType.equals("B")){
            num = num.multiply(BigDecimal.valueOf(8));
        }
        else if(getType.equals("KB")){
            num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L));
        }
        else if(getType.equals("MB")){
            num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(2));
        }
        else if(getType.equals("GB")){
            num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(3));
        }
        else if(getType.equals("TB")){
            num = num.multiply(BigDecimal.valueOf(8)).multiply(BigDecimal.valueOf(1000L).pow(4));
        }
        if(returnType.equals("b")){
            return num;
        }
        else if(returnType.equals("kb")){
            return num.divide(BigDecimal.valueOf(1000L));
        }
        else if(returnType.equals("mb")){
            return num.divide(BigDecimal.valueOf(1000L).pow(2));
        }
        else if(returnType.equals("gb")){
            return num.divide(BigDecimal.valueOf(1000L).pow(3));
        }
        else if(returnType.equals("B")){
            return num.divide(BigDecimal.valueOf(8));
        }
        else if(returnType.equals("KB")){
            return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L));
        }
        else if(returnType.equals("MB")){
            return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(2));
        }
        else if(returnType.equals("GB")){
            return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(3));
        }
        else if(returnType.equals("TB")){
            return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(4));
        }
        else {
            System.out.println(num + " bits (b)");
            System.out.println(num.divide(BigDecimal.valueOf(1000L)) + " kilobits (kb)");
            System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(2)) + " megabits (mb)");
            System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(3)) + " gigabits (gb)");
            System.out.println(num.divide(BigDecimal.valueOf(1000L).pow(4)) + " terabits (tb)");
            System.out.println(num.divide(BigDecimal.valueOf(8)) + " Bytes (B)");
            System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L)) + " Kilobytes (KB)");
            System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(2)) + " Megabytes (MB)");
            System.out.println(num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(3)) + " Gigabytes (GB)");
        }
        return num.divide(BigDecimal.valueOf(8)).divide(BigDecimal.valueOf(1000L).pow(4));
    }

    /**
     * Calculates the Time needed for downloads and uploads
     * @param fileSize Size of the transfering file
     * @param fileSizeType Unit type of the file
     * @param bandwidth Amound of bandwidth
     * @param bandwidthSizeType Unit type of the bandwidth
     * @return Returns a String that gives the time for a download/upload
     */
    public static String downloadTimeCalc(BigInteger fileSize, String fileSizeType, BigInteger bandwidth, String bandwidthSizeType){
        BigDecimal time = dataUnitConvert(new BigDecimal(fileSize),fileSizeType,"b").divide(dataUnitConvert(new BigDecimal(bandwidth),bandwidthSizeType,"b"));
        BigInteger days = new BigInteger("0");
        int hours = 0;
        int minutes = 0;
        double seconds = 0;
        /*if(1<=time.compareTo(BigDecimal.valueOf(86400))){
            days = time.divide(BigDecimal.valueOf(86400),50, RoundingMode.HALF_UP).toBigInteger();
        }

         */
        int scale = 50;
        days = time.divide(BigDecimal.valueOf(86400),scale, RoundingMode.HALF_EVEN).toBigInteger();
        //hours = time.remainder(BigDecimal.valueOf(86400)).divide(BigDecimal.valueOf(3600),scale, RoundingMode.HALF_EVEN).intValue();
        hours = (time.intValue()%86400)/3600;
        //minutes = time.remainder(BigDecimal.valueOf(86400)).remainder(BigDecimal.valueOf(3600)).divide(BigDecimal.valueOf(60),scale, RoundingMode.HALF_EVEN).intValue();
        minutes = (time.intValue()%86400)%3600/60;
        //seconds = time.remainder(BigDecimal.valueOf(86400)).remainder(BigDecimal.valueOf(3600)).remainder(BigDecimal.valueOf(60)).intValue();
        seconds = (time.doubleValue()%86400)%3600%60;
        return "Days: " + days + " Hours: " + hours + " Minutes: " + minutes + " Seconds: " + seconds;
    }

    /**
     * Calculates the Bandwidth for a Website
     * @param pgViews Page Views
     * @param pgPeriod Selected period over which pages views occured
     * @param avgPgSize Size of the page
     * @param pgUnit Units for size of page
     * @param redunF Redundancy Frequency
     */
    public static void websiteBandwidthCalc(Double pgViews, int pgPeriod, long avgPgSize, String pgUnit, double redunF){
        if(pgPeriod==1){
            //pgViews = pgViews*2592000;
        }
        else if(pgPeriod==2){
            pgViews = pgViews/43800;
        }
        else if(pgPeriod==3){
            pgViews = pgViews/730;
        }
        else if(pgPeriod==4){
            pgViews = pgViews/30.417;
        }
        else if(pgPeriod==5){
            pgViews = pgViews/4.34524;
        }
        BigDecimal bandwidth = dataUnitConvert(BigDecimal.valueOf(avgPgSize), pgUnit, "b").multiply(BigDecimal.valueOf(pgViews));
        System.out.println("Actual bandwidth needed is " + dataUnitConvert(bandwidth,"b","mb") + " Mbits/s or " + dataUnitConvert(bandwidth,"b","GB").multiply(BigDecimal.valueOf(30)) + " GB per month");
        bandwidth = dataUnitConvert(BigDecimal.valueOf(avgPgSize), pgUnit, "b").multiply(BigDecimal.valueOf(pgViews).multiply(BigDecimal.valueOf(redunF)));
        System.out.println("With Redundancy Factor: " + dataUnitConvert(bandwidth,"b","mb") + " Mbits/s or " + dataUnitConvert(bandwidth,"b","GB").multiply(BigDecimal.valueOf(30)) + " GB per month");
    }

    /**
     * Function Testing
     */
    public static void testCase(){
        final long TEST_NUMBER = 100L;
        final String TEST_BINARY = "1100100";
        final String TEST_HEXADECIMAL = "64";
        System.out.println("Decimal to Binary Converter:");
        System.out.println("Number: " + TEST_NUMBER + " Converted: " + toBinary(TEST_NUMBER) + " Expected: 1100100");
        System.out.println();
        System.out.println("Binary to Decimal Converter:");
        System.out.println("Binary: " + TEST_BINARY + " Converted: " + binToDecimal(TEST_BINARY) + " Expected: 100");
        System.out.println();
        System.out.println("Binary Calculator:");
        System.out.println("Input: 1100100 + 1100100 Output: " + binaryCalc("1100100 + 1100100") + " Expected: 200");
        System.out.println();
        System.out.println("Decimal to Hexadecimal Converter:");
        System.out.println("Number: " + TEST_NUMBER + " Converted: " + toHex(TEST_NUMBER) + " Expected: 64");
        System.out.println();
        System.out.println("Hexadecimal to Decimal Converter:");
        System.out.println("Hexadecimal: " + TEST_HEXADECIMAL + " Converted: " + hexToDecimal(TEST_HEXADECIMAL) + " Expected: 100");
        System.out.println();
        System.out.println("Hexadecimal Calculator:");
        System.out.println("Input: 64 + 64 Output: " + hexadecimalCalc("64 + 64") + " Expected: 200");
        System.out.println();
        System.out.println("Data Unit Converter:");
        System.out.println("Actual:");
        System.out.println("Amount of Data: 500 Data Unit: Megabytes (MB) ");
        System.out.println(dataUnitConvert(BigDecimal.valueOf(500),"MB","") + " Terrabytes (TB)");
        System.out.println();
        System.out.println("Expected:\n4000000000 bits (b)\n" +
                "4000000 kilobits (kb)\n" +
                "4000 megabits (mb)\n" +
                "4 gigabits (gb)\n" +
                "0.004 terabits (tb)\n" +
                "500000000 Bytes (B)\n" +
                "500000 Kilobytes (KB)\n" +
                "0.5 Gigabytes (GB)\n" +
                "0.0005 Terabytes (TB)");
        System.out.println();
        System.out.println("Download/Upload Time Calculator:");
        System.out.println("File Size: 123MB Bandwidth: 12 Mbit/s\nExpected:");
        System.out.println(downloadTimeCalc(BigInteger.valueOf(123),"MB",BigInteger.valueOf(12),"mb"));
        System.out.println("Actual:\nDays: 0 Hours: 0 Minutes: 1 Seconds: 22");
        System.out.println();
        System.out.println("Website Bandweidth Calculator\nPage Views: 1 view/sec Average Page Size: 1 Byte Redundancy Factor: 1\nExpected: ");
        websiteBandwidthCalc(1.0,1,1,"B",1);
        System.out.println("Actual: \nActual bandwidth needed is 0.000008 Mbits/s or 3.0E-8 GB per month\n" +
                "With Redundancy Factor: 0.0000104 Mbits/s or 3.90E-8 GB per month");
        System.out.println();
    }
}
