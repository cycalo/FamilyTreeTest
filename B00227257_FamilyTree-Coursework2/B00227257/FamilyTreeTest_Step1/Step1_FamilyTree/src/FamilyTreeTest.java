
public class FamilyTreeTest {

    public static void main(String[] args) {
        String name = Input.getString("Input the ancestors name: ");
        String partner = Input.getString("Input the partners name: ");
        FamilyTree familytree = new FamilyTree(name, partner);
        FamilyTree familytree2 = new FamilyTree(partner, name);
        Integer option;
        do{
            System.out.println("1: Add Child");
            System.out.println("2: display FamilyTree");
            System.out.println("0: To quit");
            option = Input.getInteger("input menu number: ");
            switch(option) {
                case 1:
                    name = Input.getString("Input the childs name: ");
                    familytree.addChild(name);
                    familytree2.addChild(name);
                    break;
                    
                case 2:
                    System.out.println(familytree);
                    System.out.println(familytree2);
                    break;
            }
        } while(option != 0);
    }
    
}
