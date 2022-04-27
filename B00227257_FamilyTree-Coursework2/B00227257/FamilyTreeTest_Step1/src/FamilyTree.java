
public class FamilyTree {

    private class FamilyTreeNode {

        private String name;
        private FamilyTreeNode partner;
        private FamilyTreeNode sibling;
        private FamilyTreeNode child;
    }

    private FamilyTreeNode ancestor;
    private FamilyTreeNode current;

    //constructor
    public FamilyTree(String ancestorName, String partnerName) {
        this.ancestor = new FamilyTreeNode();
        this.ancestor.name = ancestorName;

        this.ancestor.partner = new FamilyTreeNode();
        this.ancestor.partner.name = partnerName;
        this.current = this.ancestor;;
    }

    //adds child to ancestors partner
    public void addChild(String name) {
        FamilyTreeNode family = new FamilyTreeNode();
        family.name = name;
        family.partner = this.current;
        if (this.current.child == null) {
            this.current.child = family;
        } else {
            FamilyTreeNode next = this.current.child;

            while (family.sibling != null) {
                family = family.sibling;

            }
            while (next.sibling != null) {
                next = next.sibling;
            }
            next.sibling = family;
        }
    }

//get children from familytreenode into string
    private String getChildren(FamilyTreeNode family) {
        String childrenDetails = new String();
        family = family.child;
        if (family == null) {
            childrenDetails += "";
        } else {
            while (family != null) {
                childrenDetails += "   " + family.name + "\n";
                family = family.sibling;
            }
        }
        return childrenDetails;
    }

    //toString method to display family tree via ancestor and partner
    public String toString() {
        String familyDetails = new String();
        familyDetails += this.ancestor.name + " partner " + this.ancestor.partner.name + "\n";
        FamilyTreeNode family = this.ancestor.child;
        if (family == null) {
            familyDetails += " has no children\n";
        } else {
            while (family != null) {
                familyDetails += "  " + family.name + "\n";
                familyDetails += this.getChildren(family);
                family = family.sibling;
            }
        }
        familyDetails += this.ancestor.partner.name + " partner " + this.ancestor.name + "\n";
        FamilyTreeNode family2 = this.ancestor.child;
        if (family2 == null) {
            familyDetails += " has no children\n";
        } else {
            while (family2 != null) {
                familyDetails += "  " + family2.name + "\n";
                familyDetails += this.getChildren(family2);
                family2 = family2.sibling;
            }
        }
        return familyDetails;
    }

}
