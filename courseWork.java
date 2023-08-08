import java.util.*;
class courseWork{
	private static Scanner input=new Scanner(System.in);
	private static String[][] user={{"Dilan","1234"},{"Lahiru","5678"},{"Kasun","1357"}};
	private static String [][] supplair=new String[0][2];
	private static String []itemCategory = new String [0];
	private static String [][] item =new String [0][6];
	
	private  final  static  void  clearConsole()  {
		
		//clear the console
		
		try  {
		new  ProcessBuilder("cmd",  "/c",  "cls").inheritIO().start().waitFor(); 
		}  catch  (final  Exception  e)  { 
		System.err.println(e.getMessage()); 
		}
		}
	
	public static void printLine(){
		
		//print line
		
		System.out.print("+");
		for (int i = 0; i <71; i++)
		{
		System.out.print("-");
		}
		System.out.println("+");
	}
	

	public static void loginPage(){
		
		//Login page
		
		printLine();
		System.out.println("|\t\t\t\tLOGIN PAGE\t\t\t\t|");
		printLine();
	}
	
	
	public static boolean cheakName(String name){
		
		//cheak Name is available in the array
		
		for (int i = 0; i <user.length; i++){
		
			if(user[i][0].equals(name)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public static boolean cheakPassWord(String passWord,String name){
		
		//cheak password is available in the array
		
		for (int i = 0; i <user.length; i++)
		{
			if(user[i][0].equals(name) & user[i][1].equals(passWord)){
				return true;
			}
		}
		return false;
	}
	
	
	public static void homePage(){
		
		//Home page
		
		printLine();
		System.out.println("|\t\tWELCOME TO IJSE STORCK MANAGEMENT SYSTEM\t\t|");
		printLine();
		System.out.print("\n[1] Change the Credentials \t\t [2]"+
		"Supplier Manage\n[3] Stock Manage \t\t\t [4] Log out\n[5] Exit the system");
	}
	
	
	public static void credentialManage(){
		
		//credential Manage page
		
		printLine();
		System.out.println("|\t\t\t    CREDENTIAL MANAGE    \t\t\t|");
		printLine();
	}
	
	
	
	//get action using home page input
	public static void getAction(){
		
		boolean optionISTrue=false,isTrue;  String name,passWord;
		
		//optionIStrue=cheak switch option 1-5 =true
		//isTrue=cheak user name and password
		
		System.out.print("\n\nEnter an option to coninue > ");
		int option=input.nextInt();
		
		
		do{
			switch(option){
				case 1:
					optionISTrue= true;	
					
					clearConsole();//clear the console
					
					credentialManage();
					
					System.out.print("\nPlease enter the user name to verify it's you : ");
					name=input.next();
					
					isTrue=cheakName(name);
					
					if(isTrue==false){
						while(isTrue==false){
							System.out.println("invalid user name. try agin!");
							System.out.print("\nPlease enter the user to verify it's you  : ");
							name =input.next();
							isTrue=cheakName(name);
							
						}
					}
					System.out.println("Hey "+name);
					
					System.out.print("Enter your current password : ");
					passWord=input.next();
					
					isTrue=cheakPassWord(passWord,name);
					
					if(isTrue==false){
						while(isTrue==false){
							System.out.println("incorrect password. try agin!");
							System.out.print("\nEnter your current password : ");
							passWord=input.next();
							isTrue=cheakPassWord(passWord,name);
						}
					}
					
					System.out.print("Enter your new password : ");
					String newPassWord=input.next();
					
					changePassWord(name,passWord,newPassWord);
					
					System.out.print(" Do you want to go home page (Y/N) : ");
					char YorN=input.next().charAt(0);
					
					if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
						while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
							System.out.print("\nincorrect Letter.please Enter (Y/N) : ");
							YorN=input.next().charAt(0);
						}
						
					}
					
					if(YorN=='Y'|YorN=='y'){
						clearConsole();
						homePage();
						getAction();
					}else if(YorN=='N'|YorN=='n'){
						
						System.exit(0);
						
					}
					break;
						
				case 2:
					optionISTrue= true;
					
					clearConsole();//clear the console
					
					supplirManagePage();
					
					getSupplairAction();
					
					break;
				case 3:
					optionISTrue= true;
					
					clearConsole();//clear the console
					
					printStockManagePage();
					
					stockManagenentGetAction();
					
					break;
				case 4:
					optionISTrue= true;
					
					clearConsole();//clear the console
					
					loginPage();
	
					getNameandPassWord();
		
					clearConsole();
		
					homePage();		
		
					getAction();
					
					break;
				case 5:
					optionISTrue= true;
					
					clearConsole();//clear the console
					
					System.exit(0);
					
				default:
					optionISTrue= false;
					System.out.println("invaled option.please try agin!");
					System.out.print("\n\nEnter an option to coninue > ");
					option=input.nextInt();
				}
				
			}
				while (optionISTrue==false);
	}
	
	
	
	public static void changePassWord(String name,String passWord,String newPassWord){
		
		//change password
		
		for (int i = 0; i <user.length ; i++)
		{
			if(user[i][1].equals(passWord)){
				user[i][1]=newPassWord;
				System.out.print("\nPassword changed successfully!");
			}
		}
		
	}
	
	
	
	public static void getNameandPassWord(){
		
		//get name and password in login page
		
		System.out.print("\nUser Name : ");
		String name =input.next();
		
		boolean isTrue=cheakName(name);
		
		if(isTrue==false){
			while(isTrue==false){
			System.out.println("user name is invalid. please try agin!");
			System.out.print("\nuser name : ");
			name =input.next();
			isTrue=cheakName(name);
		}
		
		}
		System.out.print("\nPassword : ");
		String passWord =input.next();
		
		isTrue=cheakPassWord(passWord,name);
		
		if(isTrue==false){
			while(isTrue==false){
			System.out.println("password is incorrect.please try agin!");
			System.out.print("\npassword : ");
			passWord=input.next();
			isTrue=cheakPassWord(passWord,name);
				
			}
		}
		
	}
	
	
	
	public static void supplirManagePage(){
		
		//print suplair manage page
		
		printLine();
		System.out.println("|\t\t\t\tSUPPLIER MANAGE\t\t\t\t|");
		printLine();
		System.out.print("\n[1] Add Supplier \t\t\t [2] Update Supplier"+
						 "\n[3] Delete Suplier \t\t\t [4] View Supplier"+
						 "\n[5] Serch Supplier \t\t\t [6] Home Page");
		
	}
	
	
	
	public static void getSupplairAction(){
		
		//get Action for first switch case
		
		boolean optionISTrue=false;
		
		//optionIStrue=cheak switch option 1- =true
		
		
		System.out.print("\n\nEnter an option to coninue > ");
		int option=input.nextInt();
		
		
		do{
			switch(option){
				case 1:
					optionISTrue=true;
					
					addSupplair();
					
					break;
				case 2:
					optionISTrue=true;
					
					clearConsole();
					
					updateSupplairPage();
					
					updateSupplair();
					
					break;
					
				case 3:
					optionISTrue=true;
					
					clearConsole();
					
					printDeleateSupplairPage();
					
					deleteSupplair();
					
					
					break;
				case 4:
					optionISTrue=true;
					
					clearConsole();
					
					printViewSupplairPage();
					
					printSupplair();
					
					break;
				case 5:
					optionISTrue=true;
					
					clearConsole();
					
					printSearchSupplairPage();
					
					searchSupplair();
					
					
					break;
				case 6:
					optionISTrue=true;
					
					clearConsole();
					
					homePage();		
		
					getAction();
					break;
				default:
					optionISTrue=false;
					System.out.println("invaled option.please try agin!");
					System.out.print("\n\nEnter an option to coninue > ");
					option=input.nextInt();
				}
						
		}while(optionISTrue==false);
	}
	
	
	
	public static String[][] grow(){
		
		//grow array to store suplair
		
		String[][] temp = new String[supplair.length+1][2] ;
		
		for(int i=0; i<supplair.length; i++){
				temp[i][0]=supplair[i][0];
				temp[i][1]=supplair[i][1];	
		}
		return temp;
	}
	
	
	
	public static void addSupplairPage(){
		
		//print add suplair page
		
		printLine();
		System.out.println("|\t\t\t\tAdd SUPPLIER\t\t\t\t|");
		printLine();
		
	}
	
	
	
	public static void addSupplairNameAndID(){
		
		//get input and adda supplair
		
		boolean supNameIsTrue=false;
		
		System.out.print("\nSupplier ID : ");
		String supID=input.next();
		
		supNameIsTrue=cheakSupID(supID);
		
		while(supNameIsTrue==true){
			System.out.println("alrady exit. try another supplier ID!");
			System.out.print("\nSupplier ID : ");
			supID=input.next();
			
			supNameIsTrue=cheakSupID(supID);
		}
		
			
		supplair=grow();
				
		supplair[supplair.length-1][0]=supID;
					
		System.out.print("Supplier Name : ");
		String supName=input.next();
					
		supplair[supplair.length-1][1]=supName;
					
		System.out.print("added successfully!");
	}
	
	
	public static boolean cheakSupID(String supID){
		
		//cheak supplair Id is avalble here 
		
		for(int i=0; i<supplair.length;i++){
			if(supID.equals(supplair[i][0])){
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void addSupplair(){
		
		//get action in second switch in suplair manage
		
					clearConsole();
					
					addSupplairPage();
					
					addSupplairNameAndID();
					
					System.out.print(" Do you want to add another supplier (Y/N)? ");
					char YorN=input.next().charAt(0);
					
					if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
						while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
							System.out.print("incorrect Letter.please Enter (Y/N) : ");
							YorN=input.next().charAt(0);
						}
						
					}
					
					if(YorN=='Y'|YorN=='y'){
						
						addSupplair();
						
						return;
					
						
					}else if(YorN=='N'|YorN=='n'){
							clearConsole();//clear the console
					
							supplirManagePage();
					
							getSupplairAction();
							
							return;
					}
				}
	public static void updateSupplairPage(){
		
		//print add update suplair page
		
		printLine();
		System.out.println("|\t\t\t\tUPDATE SUPPLIER\t\t\t\t|");
		printLine();
		
	}
	
	public static void updateSupplair(){
		
		boolean supIDIsTrue=false,supNameISTrue=false;
		
		String supName=null;
		String supID=null;
		
		int index=-1;
					
		while(supIDIsTrue==false){
			
			System.out.print("\nSupplier ID : ");
			supID=input.next();
			
		
			supIDIsTrue=cheakSupID(supID);
			
			index=getSuplairIDIndex(supID);
		
			if(supIDIsTrue==true){
				
				System.out.println("Suplier Name : "+supplair[index][1]);
					
				System.out.print("\nEnter the new Suplier Name : ");
				supName=input.next();

			}else{
				System.out.println("can't sind Supplier ID. try agin!");
			}
		}
		
		index=getSuplairIDIndex(supID);
		
		supplair[index][1]=supName;
		
		System.out.print("Updated Sucessfully! ");
		
		System.out.print(" Do you want to update another supplier (Y/N)? ");
		char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
						while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				updateSupplairPage();
		
				updateSupplair();
				
				return;
		
			}else if(YorN=='N'|YorN=='n'){
				
				clearConsole();//clear the console
					
				supplirManagePage();
					
				getSupplairAction();
				
				return;
				
			}
		
	}
	
	
	public static int getSuplairIDIndex(String supID){
		
		for(int i=0; i<supplair.length; i++){
			
			if(supID.equals(supplair[i][0])){
				
				return i;
			}
		}
		
		return 0;
	}
	
	public static void printDeleateSupplairPage(){
		
		printLine();
		System.out.println("|\t\t\t\tDELETE SUPPLIER\t\t\t\t|");
		printLine();
	}
	
	public static void deleteSupplair(){
		
		boolean supIDIsTrue=false; String supID=null;

		while(supIDIsTrue==false){
		
			System.out.print("\nSupplier id : ");
			supID=input.next();
		
			supIDIsTrue=cheakSupID(supID);
			
			if(supIDIsTrue==false){
				
				System.out.println("can't find supplier id. try agin!");
			}
		
	}
	
		int index =getSuplairIDIndex(supID);
		
		lose(index);
		
		System.out.print(" Do you want to delete another supplier (Y/N)? ");
		char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
				
				printDeleateSupplairPage();
					
				deleteSupplair();
					
				return;
		
			}else if(YorN=='N'|YorN=='n'){
				
				clearConsole();//clear the console
					
				supplirManagePage();
					
				getSupplairAction();
				
				return;
			}
		
		
	}
	
	public static void lose(int index){
		
		String [][] temp=new String [supplair.length-1][supplair[0].length];
		
		for(int i=0,j=0; i<supplair.length; i++){
			
			if(i==index){
				continue;
			}
			
			temp[j][0]=supplair[i][0];
			temp[j][1]=supplair[i][1];
			j++;
		}
		
		supplair=temp;
		
		System.out.print("delete successfully!");
		
			
	}
	
	public static void printViewSupplairPage(){
		
		printLine();
		System.out.println("|\t\t\t\tVIEW SUPPLIER\t\t\t\t|");
		printLine();
		
	}
	
	public static void printSupplair(){
		
		System.out.printf("+--------------------------+--------------------------+%n");
		System.out.printf("|      %-16s    |      %-15s     |%n","Supplier ID","Supplier Name");
		System.out.printf("+--------------------------+--------------------------+%n");
		
		for (int i = 0; i <supplair.length; i++){
				
				System.out.printf("|      %-16s    |      %-15s     |%n",supplair[i][0],supplair[i][1]);
				
			}
				
		System.out.printf("+--------------------------+--------------------------+%n");	
		
		System.out.print(" Do you want to go Supplier manage page(Y/N)? ");
		char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();//clear the console
					
				supplirManagePage();
					
				getSupplairAction();
				
				return;
					
				
		
			}else if(YorN=='N'|YorN=='n'){
				
				System.exit(0);
				
			}
	}
	
	public static void printSearchSupplairPage(){
		
		printLine();
		System.out.println("|\t\t\t\tSEARCH SUPPLIER\t\t\t\t|");
		printLine();
		
	}
	
	public static void searchSupplair(){
		
		boolean SupIDISTrue=false;  int index=-1;
		
		System.out.print("\nSupplier ID : ");
		String supID = input.next();
		
		SupIDISTrue=cheakSupID(supID);
		
		if(SupIDISTrue==true){
			
			index=getSuplairIDIndex(supID);
			
			System.out.print("Supplair Name : "+supplair[index][1]);
			
			System.out.print("\nadded successfully!");
		}
		
		if(SupIDISTrue==false){
			
			System.out.println("can't find Supplier id. try agin!");
			
			searchSupplair();
		}
		
		System.out.print(" Do you want to find  another Supplier(Y/N)? ");
		char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				printSearchSupplairPage();
					
				searchSupplair();
				
				return;
				
		
			}else if(YorN=='N'|YorN=='n'){
				
				clearConsole();//clear the console
					
				supplirManagePage();
					
				getSupplairAction();
				
				return;
				
			}
	}
	
	public static void printStockManagePage(){
		
		printLine();
		System.out.println("|\t\t\t    STOCK MANAGEMENT    \t\t\t|");
		printLine();
		
		System.out.print("\n[1] Manage Item Categories \t\t\t [2]Add Item\n"+
						"[3] Get Item Supplier Wice \t\t\t [4]view Items\n"+
						"[5] Rank Items Per Unit Price \t\t\t [6]Home page\n");
		
	}
	
	public static void stockManagenentGetAction(){
		
		boolean optionISTrue=false;
		
		//optionIStrue=cheak switch option 1- =true
		
		
		System.out.print("\n\nEnter an option to coninue > ");
		int option=input.nextInt();
		
		
		do{
			switch(option){
				case 1:
					optionISTrue=true;
					
					clearConsole();
					
					printManageItemcategory();
					
					manageItemCategoryGetAction();
					
					break;
				case 2:
					optionISTrue=true;
					
					clearConsole();
					
					printAddItempage();
					
					addItemGetAction();
					
					break;
					
				case 3:
					optionISTrue=true;
					
					clearConsole();
					
					serchSupplairPage();
					
					searchSupplairGetAction();
				
					break;
					
				case 4:
					optionISTrue=true;
					
					clearConsole();
					
					printViewItemsPage();
					
					viewItemsGetAction();
					
					break;
					
				case 5:
					optionISTrue=true;
					
					clearConsole();
					
					printRankedPage();
					
					rankGetAction();
			
					break;
					
				case 6:
					optionISTrue=true;
					
					clearConsole();
					
					homePage();		
		
					getAction();
					break;
				default:
					optionISTrue=false;
					System.out.println("invaled option.please try agin!");
					System.out.print("\n\nEnter an option to coninue > ");
					option=input.nextInt();
				}
						
		}while(optionISTrue==false);
	}
	
	public static void printManageItemcategory(){
		
		printLine();
		System.out.println("|\t\t\t    MANAGE ITEM CATEGORY    \t\t\t|");
		printLine();
		
		System.out.print("\n[1] Add New Item Category \t\t [2] Delete Item Category\n"+
						"[3] Update Item Category \t\t [4]Stock Management");
						
	}
	
	public static void manageItemCategoryGetAction(){
		
		boolean optionISTrue=false;
		
		//optionIStrue=cheak switch option 1- =true
		
		
		System.out.print("\n\nEnter an option to coninue > ");
		int option=input.nextInt();
		
		
		do{
			switch(option){
				case 1:
					optionISTrue=true;
					
					clearConsole();
					
					printAddIteamCategoryPage();
					
					addIteamCategorygetAction();
					
					
					break;
				case 2:
					optionISTrue=true;
					
					clearConsole();
					
					printDeleteIteamCategoryPage();
					
					deleteIteamCategoryGetAction();
					
					
					break;
					
				case 3:
					optionISTrue=true;
					
					clearConsole();
					
					printupdateItemCategoryPage();
					
					updateItemCategoryGetAction();
				
					break;
					
				case 4:
					optionISTrue=true;
					
					clearConsole();//clear the console
					
					printStockManagePage();
					
					stockManagenentGetAction();
					
			
					
					break;
					
				default:
					optionISTrue=false;
					System.out.println("invaled option.please try agin!");
					System.out.print("\n\nEnter an option to coninue > ");
					option=input.nextInt();
				}
						
		}while(optionISTrue==false);
		
	}
	
	public static void printAddIteamCategoryPage(){
		
		printLine();
		System.out.println("|\t\t\t    ADD ITEM CATEGORY    \t\t\t|");
		printLine();
		
	}
	
	public static void addIteamCategorygetAction(){
		
		boolean categoriIsTrue=false;
		
		System.out.print("\nEnter the new item category : ");
		String category=input.next();
		
		categoriIsTrue=cheakCategory(category);
		
		if (categoriIsTrue==true){
			
			System.out.println("iteam category is already exits. try another category");
			
			addIteamCategorygetAction();
		}
		else if(categoriIsTrue==false){
			
			grow1D();
			
			itemCategory[itemCategory.length-1]=category;
			
			System.out.print("added successfully!");
		}
		
			System.out.print(" Do you want to add another category(Y/N)? ");
			char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				printAddIteamCategoryPage();
					
				addIteamCategorygetAction();
				
				return;
				
			}else if(YorN=='N'|YorN=='n'){
				
				clearConsole();
					
				printManageItemcategory();
					
				manageItemCategoryGetAction();
				
				return;
				
			}
	}
	
	public static void grow1D(){
		
		String[] temp=new String[itemCategory.length+1];
		
		for (int i = 0; i <itemCategory.length; i++){
			
			temp[i]=itemCategory[i];
			
		}
		
		itemCategory=temp;
	}
	
	public static boolean cheakCategory(String category){
		
		for (int i = 0; i < itemCategory.length; i++){
			
			if(itemCategory[i].equals(category)){
				
				return true;
			}
		}
		return false;
		
	}
	
	public static void printDeleteIteamCategoryPage(){
		
		printLine();
		System.out.println("|\t\t\t    DELETE ITEM CATEGORY    \t\t\t|");
		printLine();
		
	}
	
	public static void deleteIteamCategoryGetAction(){
		
		boolean categoryIsTrue=false;
		
		System.out.print("\nEnter the item category name : ");
		String category=input.next();
		
		categoryIsTrue=cheakCategory(category);
		
		if(categoryIsTrue==false){
			
			System.out.println("can't find item category! try agin ");
			deleteIteamCategoryGetAction();
		}
		
		else if(categoryIsTrue==true){
			
			lose1D(category);
			
		}
		
		System.out.print(" Do you want to delete another category(Y/N)? ");
		char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				printDeleteIteamCategoryPage();
					
				deleteIteamCategoryGetAction();
				
				return;
				
			}else if(YorN=='N'|YorN=='n'){
				
				clearConsole();
					
				printManageItemcategory();
					
				manageItemCategoryGetAction();
				
				return;
				
			}
		
	}
	
	
	public static void lose1D(String category){
		
		String[] temp = new String[itemCategory.length-1]; 
		
		for (int i = 0,j=0; i < itemCategory.length; i++)
		{
			if(itemCategory[i].equals(category)){
				
				continue;
				
				
			}
			
			temp[j]=itemCategory[i];
			j++;
			
		}
		
		itemCategory=temp;
		
		System.out.print("\ndelete successfully!");
		
	}
	
	public static void printupdateItemCategoryPage(){
		
		printLine();
		System.out.println("|\t\t\t    UPDATE ITEM CATEGORY    \t\t\t|");
		printLine();
		
	}
	
	public static void updateItemCategoryGetAction(){
		
		boolean categoryIsTrue=false;
		
		System.out.print("\nEnter item category : ");
		String category=input.next();
		
		categoryIsTrue=cheakCategory(category);
		
		if(categoryIsTrue==true){
			
			System.out.print("Enter new item category : ");
			String newCategory=input.next();
			
			cheakCategoryIndex(category,newCategory);
			
			System.out.print(" Do you want to update another category(Y/N)? ");
			char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				printupdateItemCategoryPage();
					
				updateItemCategoryGetAction();
				
				return;
				
			}else if(YorN=='N'|YorN=='n'){
				
				clearConsole();
					
				printManageItemcategory();
					
				manageItemCategoryGetAction();
				
				return;
				
			}
			
			
		}else if(categoryIsTrue==false){
			
			System.out.println("can't find item category! try agin ");
			updateItemCategoryGetAction();
		}
		
	}
	
	
	public static void cheakCategoryIndex(String category,String newCategory){
		
		for (int i = 0; i <itemCategory.length; i++){
			
			if(itemCategory[i].equals(category)){
				
				itemCategory[i]=newCategory;
			}
		}
		System.out.print("update successfully!");
	}
	
	public static void printAddItempage(){
		
		printLine();
		System.out.println("|\t\t\t\tADD ITEM\t\t\t\t|");
		printLine();
		
	}
	
	
	public static void addItemGetAction(){
		
		if(itemCategory.length==0){
			
			System.out.println("\noops! It seems that you don't have any item categories in the System.");
			
			System.out.print("Do you want to add a new item category(Y/N)? ");
			char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				printAddIteamCategoryPage();
					
				addIteamCategorygetAction();
				
				return;
				
			}else if(YorN=='N'|YorN=='n'){
				
				clearConsole();
					
				printStockManagePage();
					
				stockManagenentGetAction();
				
				return;
				
			}
		}else if(supplair.length==0){
				
				System.out.println("\noops! It seems that you don't have any suppliers in the System.");
				
				System.out.print("Do you want to add a new supplier(Y/N)? ");
				char YorN=input.next().charAt(0);
					
				if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
						System.out.print("incorrect Letter.please Enter (Y/N) : ");
						YorN=input.next().charAt(0);
					}
						
				}
					
				if(YorN=='Y'|YorN=='y'){
					
					addSupplair();
					
					return;
				
				}else if(YorN=='N'|YorN=='n'){
				
					clearConsole();
					
					printStockManagePage();
					
					stockManagenentGetAction();
					
					return;
				
			}
			}
			
		
		if(supplair.length !=0 & itemCategory.length!=0){
			
			
			
			System.out.print("\nItem code : ");
			String Icode=input.next();
			
					
		if(item.length>=1){
		
			for (int i = 0; i <item.length; i++){
				if(item[i][1].equals(Icode)){
					
					System.out.println("already added.try another item code!");
					addItemGetAction();
					return;
				}
			}
		}
		
		
			item=growItem(item);
			item[item.length-1][1]=Icode;
		
			System.out.print("\n\nSuppliers list : ");
		
			System.out.printf("\n+--------------------+--------------------+-------------------+%n");
			System.out.printf("|          %-10s|     %-15s|    %-15s|%n","#","Supplier ID","Supplier Name");
			System.out.printf("+--------------------+--------------------+-------------------+%n");
		
			for (int i = 0; i <supplair.length; i++){
			
				System.out.printf("|          %-10s|     %-15s|    %-15s|%n",i+1,supplair[i][0],supplair[i][1]);
			
			}
			System.out.printf("+--------------------+--------------------+-------------------+%n");
		
			boolean SupIstrue=false;
			while(SupIstrue==false){
			System.out.print("\nEnter the supplaier number : ");
			int SupNum=input.nextInt();
		
			if(supplair.length<SupNum){
				System.out.println("Worng option.try agin!");
				SupIstrue=false;
			}else{
			
				item[item.length-1][0]=supplair[SupNum-1][0];
				SupIstrue=true;
			
				}
		}
			System.out.print("\nItem Categories : ");
		
			System.out.printf("%n+--------------------------+--------------------------+%n");
			System.out.printf("|             %-9s    |      %-15s     |%n","#","Supplier Name");
			System.out.printf("+--------------------------+--------------------------+%n");
		
			for (int i = 0; i <itemCategory.length; i++){
			
				System.out.printf("|             %-9s    |      %-15s     |%n",i+1,itemCategory[i]);
			}
		
			System.out.printf("+--------------------------+--------------------------+%n");
			boolean catIsTrue=false;
		
			while(catIsTrue==false){
			System.out.print("\nEnter the category number : ");
			int CatNum=input.nextInt();
		
			if(itemCategory.length<CatNum){
				System.out.println("Worng option.try agin!");
				catIsTrue=false;
			}else{
			
				item[item.length-1][5]=itemCategory[CatNum-1];
				catIsTrue=true;
			
				}
		
		}
			System.out.print("\n\nDescription : ");
			item[item.length-1][2]=input.next();
		
			System.out.print("Unit price : ");
			Double price=input.nextDouble();
			item[item.length-1][3]=String.valueOf(price);
		
			System.out.print("Qty on hand : ");
			item[item.length-1][4]=input.next();
		
		
		
			System.out.print("added successfully! ");
			
			System.out.print("Do you want to add a new item(Y/N)? ");
			char YorN=input.next().charAt(0);
					
				if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
						System.out.print("incorrect Letter.please Enter (Y/N) : ");
						YorN=input.next().charAt(0);
					}
						
				}
					
				if(YorN=='Y'|YorN=='y'){
				
					clearConsole();
					
					printAddItempage();
					
					addItemGetAction();
				
					return;
				
				}else if(YorN=='N'|YorN=='n'){
				
					clearConsole();
					
					printStockManagePage();
					
					stockManagenentGetAction();
				
					return;
				
				}
		}
		
	}
	
	
	public static String[][] growItem(String[][] item){
		
		String[][] grow=new String[item.length+1][6];
		
		for (int i = 0; i <item.length; i++)
		{
			for(int j=0; j<item[i].length; j++){
				
				grow[i][j]=item[i][j];
			}
		}
		return grow;
	}
	
	public static void serchSupplairPage(){
		
		printLine();
		System.out.println("|\t\t\t\tSEARCH SUPPLIER\t\t\t\t|");
		printLine();
	}
	
	public static void searchSupplairGetAction(){
		
		System.out.print("\nEnter Supplier Id : ");
		String suppId=input.next();
		
		boolean isTrue=false;
		
		isTrue=cheakSupID(suppId);
		int supIndex=0;
		
		if(isTrue==false){
			System.out.println("can't find .try agin!");
			searchSupplairGetAction();
			return;
		}
		
		supIndex=getSuplairIDIndex(suppId);
		
		System.out.println("Suplire name : "+supplair[supIndex][1]);
		
		System.out.printf("\n+--------------------+--------------------+-------------------+-------------------+--------------------+%n");
		System.out.printf("|     %-15s|     %-15s|    %-15s|    %-15s|     %-15s|%n","ITEM CODE","DISCRIPTION","UNIT PRICE","QTY ON HAND","CATEGORY");
		System.out.printf("+--------------------+--------------------+-------------------+-------------------+--------------------+%n");
		
		for (int i = 0; i <item.length; i++){
			
			if(item[i][0].equals(suppId)){
		
				System.out.printf("|     %-15s|     %-15s|    %-15s|    %-15s|     %-15s|%n",item[i][1],item[i][2],item[i][3],item[i][4],item[i][5]);
					
			}
		}
		System.out.printf("+--------------------+--------------------+-------------------+-------------------+--------------------+%n");
		
		System.out.print("search successfully! Do you want to another search(Y/N)? ");
		char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				serchSupplairPage();
					
				searchSupplairGetAction();
				
				return;
				
			}else if(YorN=='N'|YorN=='n'){
				
				clearConsole();
					
				printStockManagePage();
					
				stockManagenentGetAction();
				
				return;
				
			}
	}
	
	public static void printViewItemsPage(){
		
		printLine();
		System.out.println("|\t\t\t\tVIEW ITEMS\t\t\t\t|");
		printLine();
		
	}
	
	public static void viewItemsGetAction(){
		for (int i = 0; i <itemCategory.length; i++)
		{
			System.out.print("\n"+itemCategory[i]+" :");
			
		System.out.printf("\n+--------------------+--------------------+-------------------+-------------------+--------------------+%n");
		System.out.printf("|     %-15s|     %-15s|    %-15s|    %-15s|     %-15s|%n","SUPPLAIR ID","ITEM CODE","DISCRIPTION","UNIT PRICE","QTY ON HAND");
		System.out.printf("+--------------------+--------------------+-------------------+-------------------+--------------------+%n");
		
			
			for (int j = 0; j <item.length; j++)
			{
				if(itemCategory[i].equals(item[j][5])){
					
					System.out.printf("|     %-15s|     %-15s|    %-15s|    %-15s|     %-15s|%n",item[j][0],item[j][1],item[j][2],item[j][3],item[j][4]);
				
					}
			}
			System.out.printf("+--------------------+--------------------+-------------------+-------------------+--------------------+%n");
		
			
		}
		
		System.out.print("Do you want to go stock manage page(Y/N)? ");
		char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				printStockManagePage();
					
				stockManagenentGetAction();
				
				return;
				
			}else if(YorN=='N'|YorN=='n'){
				
				System.exit(0);
				
			}
		
		
	}
	
	public static void printRankedPage(){
		
		printLine();
		System.out.println("|\t\t\t    RANKED UNIT PRICE    \t\t\t|");
		printLine();
		
	}
	
	public static void rankGetAction(){
		
		//Double num = Double.parseDouble(item[0][3]);
		
		//System.out.print(num);
		
		//String.valueOf(num);
		
		Double num1=0.0;
		Double num2=0.0;
		
		String [] temp=new String [6];
		
	for(int k=0; k<item.length; k++){
		for (int i = 0; i <item.length-1; i++){
			
			num1=Double.parseDouble(item[i][3]);
			num2=Double.parseDouble(item[i+1][3]);
			
			if(num1>num2){
				item[i][3]=String.valueOf(num1);
				item[i+1][3]=String.valueOf(num2);
				temp=item[i+1];
				item[i+1]=item[i];
				item[i]=temp;	
			}
			
		}
	}
		
		System.out.printf("%n+--------------------+--------------------+-------------------+-------------------+--------------------+--------------------+%n");
        System.out.printf("|     %-15s|     %-15s|    %-15s|    %-15s|     %-15s|     %-15s|%n", "SUPPLIER ID", "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY ON HAND", "CATEGORY");
        System.out.printf("+--------------------+--------------------+-------------------+-------------------+--------------------+--------------------+%n");
		
			
			for (int j = 0; j <item.length; j++)
			{
					 System.out.printf("|     %-15s|     %-15s|    %-15s|    %-15s|     %-15s|     %-15s|%n", item[j][0],item[j][1],item[j][2],item[j][3],item[j][4],item[j][5]);
				
					}
			
		System.out.printf("+--------------------+--------------------+-------------------+-------------------+--------------------+--------------------+%n");
		
		System.out.print("Do you want to go stock manage page(Y/N)? ");
		char YorN=input.next().charAt(0);
					
			if(YorN != 'Y' && YorN != 'y' && YorN != 'N' && YorN != 'n'){
				while((!(YorN == 'Y' || YorN == 'y' || YorN == 'N' || YorN == 'n'))){
					System.out.print("incorrect Letter.please Enter (Y/N) : ");
					YorN=input.next().charAt(0);
				}
						
			}
					
			if(YorN=='Y'|YorN=='y'){
				
				clearConsole();
					
				printStockManagePage();
					
				stockManagenentGetAction();
				
				return;
				
			}else if(YorN=='N'|YorN=='n'){
				
				System.exit(0);
				
			}
		
		
	}

	
	//Main method is heare 

	public static void main(String args[]){
		
		loginPage();
	
		getNameandPassWord();
		
		clearConsole();
		  
		homePage();		
		
		getAction();
				
			
	}
}
		//Dilan Madushanka Fernando
				//GDSE 67
	
