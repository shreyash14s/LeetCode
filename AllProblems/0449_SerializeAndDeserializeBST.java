/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) recSer(sb, root);
        // System.out.println(sb.toString());
        return sb.toString();
    }
    
    void recSer(StringBuilder sb, TreeNode root) {
        sb.append(root.val);
        if (root.left != null) {
            sb.append(",");
            recSer(sb, root.left);
        }
        if (root.right != null) {
            sb.append(",");
            recSer(sb, root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] parts = data.split(",");
        int[] iparts = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            iparts[i] = Integer.parseInt(parts[i]);
        }
        TreeNode node = recDes(iparts, 0, iparts.length);
        return node;
    }
    
    TreeNode recDes(int[] iparts, int st, int end) {
        if (st >= end) return null;
        int i = st+1;
        while (i < end && iparts[i] < iparts[st]) i++;
        TreeNode node = new TreeNode(iparts[st]);
        if (i > st+1) {
            node.left = recDes(iparts, st+1, i);
        }
        if (i < end) {
            node.right = recDes(iparts, i, end);
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
