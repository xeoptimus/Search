public class BinSearchTree {
	private BinNode root;

	private class BinNode {
		private BinNode Lchild;
		private BinNode Rchild;
		private int Value;

		BinNode(int value) {
			Lchild = null;
			Rchild = null;
			Value = value;
		}
	}

	BinSearchTree() {
		root = null;
	}

	public void insertnode(int key) {
		BinNode parentnode = null;
		BinNode nodenow = root;
		if (root == null) {
			root = new BinNode(key);
			return;
		}
		while (nodenow != null) {
			parentnode = nodenow;
			if (nodenow.Value > key) {
				nodenow = nodenow.Lchild;
			} else if (nodenow.Value < key) {
				nodenow = nodenow.Rchild;
			} else {
				return;
			}
		}
		if (key < parentnode.Value) {
			parentnode.Lchild = new BinNode(key);
		} else {
			parentnode.Rchild = new BinNode(key);
		}
	}

	public void preOrder(BinNode node) {
		if (node != null) {
			System.out.println(node.Value + " ");
			preOrder(node.Lchild);
			preOrder(node.Rchild);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 8, 6, 11, 20 };
		BinSearchTree mytree = new BinSearchTree();
		for (int i = 0; i < arr.length; i++) {
			mytree.insertnode(arr[i]);
		}
		mytree.preOrder(mytree.root);
	}

}
