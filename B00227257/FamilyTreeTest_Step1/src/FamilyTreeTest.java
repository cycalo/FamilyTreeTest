
public class FamilyTreeTest {

    public static void main(String[] args) {
        String name = Input.getString("Input the ancestors name: ");
        FamilyTree familytree = new FamilyTree(name);
        FamilyTree familytree2 = new FamilyTree(name);
        Integer option;
        do{
            System.out.print("\n");
            System.out.println("1: Add Child");
            System.out.println("2: Add a Partner");
            System.out.println("3: Find a family member");
            System.out.println("4: Display current family member");
            System.out.println("5: display FamilyTree");
            System.out.println("0: To quit");
            option = Input.getInteger("input menu number: ");
            switch(option) {
                case 1:
                    name = Input.getString("Input the childs name: ");
                    familytree.addChild(name);
                    familytree2.addChild(name);
                    break;
                    
                case 2:
                    name = Input.getString("Input the Partners name: ");
                    familytree.addPartner(name);
                    break;
                    
                case 3:
                    name = Input.getString("Input the family members name: ");
                    try {
                        familytree.findFamily(name);
                        System.out.println(familytree.getCurrent());
                    } catch (FamilyTree.FamilyNotFoundException e) {
                        System.out.println("not found");
                    }
                    break; 
                    
                    
                case 5:
                    System.out.println(familytree);
                    System.out.println(familytree2);
                    break;
            }
        } while(option != 0);
    }
    
}
