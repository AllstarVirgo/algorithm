package tree;

import java.util.List;
import java.util.Objects;

public class TravelTreeNode {

    public void specialTravel(TreeNode root, List<Integer> array){
        if(Objects.isNull(root)){
            return;
        }
        array.add(root.val);
        specialTravel(root.right, array);
        specialTravel(root.left, array);
    }
}
