public class Codec {
    private List<String> preorder = new ArrayList<>();
    private int idx;

    private void getPreorder(TreeNode root) {
        if (root == null) {
            preorder.add("N");
            return;
        }

        preorder.add(String.valueOf(root.val));
        getPreorder(root.left);
        getPreorder(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preorder.clear();
        getPreorder(root);
        return String.join(",", preorder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preOd = data.split(",");
        idx = 0;
        return build(preOd);
    }

    private TreeNode build(String[] preOd) {
        if (preOd[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(preOd[idx]));
        idx++;

        root.left = build(preOd);
        root.right = build(preOd);

        return root;
    }
}