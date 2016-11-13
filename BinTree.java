
public class BinTree {
	private BinNode root;

	private class BinNode {
		private BinNode Lchild;
		private BinNode Rchild;
		private int Value;

		BinNode(int value) {
			Lchild = null;
			Rchild = null;
			this.Value = value;
		}
	}

	BinTree() {
		root = null;
	}

	public void buildtree(BinNode node, int data) {
		if (root == null) {
			root = new BinNode(data);
		} else {
			if (data < node.Value) {
				if (node.Lchild == null) {
					node.Lchild = new BinNode(data);
				} else {
					buildtree(node.Lchild, data);
				}
			} else {
				if (node.Rchild == null) {
					node.Rchild = new BinNode(data);
				} else {
					buildtree(node.Rchild, data);
				}
			}
		}
	}

	public void preOrder(BinNode node) {
		if (node != null) {
			System.out.println(node.Value + " ");
			preOrder(node.Lchild);
			preOrder(node.Rchild);
		}
	}

	public void inOrder(BinNode node) {
		if (node != null) {
			inOrder(node.Lchild);
			System.out.println(node.Value + " ");
			inOrder(node.Rchild);
		}
	}

	public void postOrder(BinNode node) {
		if (node != null) {
			postOrder(node.Lchild);
			postOrder(node.Rchild);
			System.out.println(node.Value + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 8, 6, 11, 20 };
		BinTree mytree = new BinTree();
		for (int i = 0; i < arr.length; i++) {
			mytree.buildtree(mytree.root, arr[i]);
		}
		System.out.print("前序遍历" + '\n');
		mytree.preOrder(mytree.root);
		System.out.println("");
		System.out.print("中序遍历" + '\n');
		mytree.inOrder(mytree.root);
		System.out.println("");
		System.out.print("后序遍历" + '\n');
		mytree.postOrder(mytree.root);
	}

}
