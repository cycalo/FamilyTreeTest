
public class FamilyTree {
    
    private class FamilyTreeNode {
        private String name;
        private FamilyTreeNode partner;
        private FamilyTreeNode sibling;
        private FamilyTreeNode child;
    }
    
    private FamilyTreeNode ancestor;
    private FamilyTreeNode current;
    
    public FamilyTree (String ancestorName, String partnerName) {
        this.ancestor = new FamilyTreeNode();
        this.ancestor = new FamilyTreeNode();
        this.ancestor.name = ancestorName;
        this.current = this.ancestor;
      
    }
    
    public void addChild (String name) {
        FamilyTreeNode family = new FamilyTreeNode();
        family.name = name;
        //family.partner.name = name;
        family.partner = this.current;
        if (this.current.child == null) {
            this.current.child = family;
        } else {
            FamilyTreeNode next = this.current.child;
            while (next.sibling != null) {
                next = next.sibling;
            }
            next.sibling = family;
        }
    }
    
    public String toString() {
        String familyDetails = new String();
        familyDetails += this.ancestor.name + " partner " + this.ancestor.partner.name + "\n";
        FamilyTreeNode family = this.ancestor.child;
        if (family ==null) {
            familyDetails += " has no children\n";
        } else {
            while (family !=null) {
                familyDetails += "  " + family.name + "\n";
                familyDetails += this.getChildren(family);
                family = family.sibling;                       
            }
        }
        return familyDetails;
    }
 
    private String getChildren(FamilyTreeNode family) {
        String childrenDetails = new String();
        family = family.child;
        if (family == null) {
            childrenDetails += "";
        }else {
            while (family !=null) {
                childrenDetails += "   " + family.name + "\n";
                family = family.sibling;
            }
        }
        return childrenDetails;
    }
    
}
