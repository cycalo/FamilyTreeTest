
public class FamilyTree {

    private class FamilyTreeNode {

        private Integer ID;
        private String name;
        private FamilyTreeNode partner;
        private FamilyTreeNode sibling;
        private FamilyTreeNode child;

        // counter of how many family nodes there are
        private static Integer counter = 0;

        public FamilyTreeNode(String memberName) {
            this.counter++;

            // set up initial values to the attributes
            this.ID = this.counter;
            this.name = memberName;
            this.partner = null;
            this.sibling = null;
            this.child = null;
        }

        // method to get name and ID attached
        public String getName() {
            return this.name + " (ID:" + this.ID + ")";
        }

        // get current family node
        public FamilyTreeNode getFamilyNode(Integer ID) {
            // check for match
            FamilyTreeNode familyNode = null;

            if (this.ID == ID) {
                familyNode = this;
            } else {
                // does it match a partner
                if ((this.partner != null) && (this.partner.ID == ID)) {
                    familyNode = this.partner;
                }

                // does it match a sibling
                if ((familyNode == null) && (this.sibling != null)) {
                    familyNode = this.sibling.getFamilyNode(ID);
                }

                // does it match a child
                if ((familyNode == null) && (this.child != null)) {
                    familyNode = this.child.getFamilyNode(ID);
                }
            }

            return familyNode;
        }

        // view current family node in play
        public String view_current_familyNode(String white_space) {
            String familyDetails = new String();

            // create family details to string together
            familyDetails += white_space + this.getName();

            if (this.partner == null) {

                familyDetails += " has no partner\n";
            } else {

                familyDetails += " is partner of " + this.partner.getName() + "\n";

                //indent for children
                white_space += "  ";

                if (this.child == null) {

                    familyDetails += white_space + "they have no children\n";
                } else {

                    FamilyTreeNode familyNode = this.child;

                    while (familyNode != null) {
                        familyDetails += familyNode.view_current_familyNode(white_space);
                        familyNode = familyNode.sibling;
                    }
                }
            }

            return familyDetails;
        }

        // add a to end of list
        public void addChild(String childName) throws FamilyNotFoundException {
            if (this.child == null) {
                //adds first child to both parents
                this.child = new FamilyTreeNode(childName);
                this.partner.child = this.child;
            } else {
                // adds next child to last child position in the list
                FamilyTreeNode familyNode = this.child;

                if (familyNode.name.equalsIgnoreCase(childName)) {
                    throw new FamilyNotFoundException("There is already a child named, " + childName);
                }

                while (familyNode.sibling != null) {
                    familyNode = familyNode.sibling;

                    if (familyNode.name.equalsIgnoreCase(childName)) {
                        throw new FamilyNotFoundException("There is already a child named, " + childName);
                    }
                }

                familyNode.sibling = new FamilyTreeNode(childName);
            }
        }
    }

    private FamilyTreeNode ancestor;

    public FamilyTree(String ancestorName) {
        this.ancestor = new FamilyTreeNode(ancestorName);
    }

    // get current family node
    public FamilyTreeNode getFamilyNode(Integer ID) {
        return this.ancestor.getFamilyNode(ID);
    }

    // add a partner to family member
    public void addPartner() throws FamilyNotFoundException {
        // display full family tree
        System.out.print(this);

        // retrevives a family member to add the partner to via ID number
        Integer ID = Input.getInteger("Enter ID of the family member to add partner to? ");
        FamilyTreeNode familyNode = this.getFamilyNode(ID);

        if (familyNode == null) {
            throw new FamilyNotFoundException("Does not match the ID" + ID);
        }

        // does the family member already have a partner?
        if (familyNode.partner != null) {
            throw new FamilyNotFoundException("This Family Member already has a partner");
        }

        String partnerName = Input.getString("Input the partners name: ");

        familyNode.partner = new FamilyTreeNode(partnerName);
        familyNode.partner.partner = familyNode;
    }

    // add a child to family member
    public void addChild() throws FamilyNotFoundException {
        // display full family tree
        System.out.print(this);

        // get family member to add child to
        Integer ID = Input.getInteger("Enter ID of the family member to add a child to: ");
        FamilyTreeNode familyNode = this.getFamilyNode(ID);

        if (familyNode == null) {
            throw new FamilyNotFoundException("Does not match the ID" + ID);
        }

        // does the family member already have a partner?
        if (familyNode.partner == null) {
            throw new FamilyNotFoundException("Family member does not have a partner ");
        }

        String childName = Input.getString("Input the childs name: ");

        familyNode.addChild(childName);
    }

    // get current family member
    public String getFamilyMember(Integer ID) throws FamilyNotFoundException {
        // get family member
        FamilyTreeNode familyNode = this.getFamilyNode(ID);

        if (familyNode == null) {
            throw new FamilyNotFoundException("Does not match the ID " + ID);
        }

        return familyNode.view_current_familyNode("-");
    }

    public String toString() {
        return this.ancestor.view_current_familyNode("-");
    }
}
