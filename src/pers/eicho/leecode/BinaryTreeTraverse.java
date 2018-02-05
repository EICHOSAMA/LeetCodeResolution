package pers.eicho.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraverse {
	
	public static List<Integer> preorderTraverse(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>(); 
		stack.push(root);
		result.add(root.val);
		
		// record the recent popped node.
		TreeNode lastNode = null;  
		while (stack.isEmpty() == false) {
			TreeNode rt = stack.lastElement();
			TreeNode l = rt.left;
			TreeNode r = rt.right;
			
			/*
			 * case 1. rt is leaf node, pop.
			 * case 2. left child has been traversed and no right child exist, pop. nor see case 5.
			 * case 3. right child has been traversed , pop.
			 * case 4. left child has not been traversed, add to stack.
			 * case 5. right child has not been traversed, add to stack.
			 */
			
			// 1 : check whether node rt is a leaf node.
			if (l == null && r == null) {
				lastNode = rt;
				stack.pop();
				continue;
			}
			
			// 2 : check whether node rt's left node has been traversed completely.
			if (l != null && lastNode == l && null == r) {
				lastNode = rt;
				stack.pop();
				continue;
			}
			
			// 3 : check whether node rt's right node has been traversed completely.
			if (r != null && lastNode == r) {
				lastNode = rt;
				stack.pop();
				continue;
			}
			
			// 4 : traverse left node .
			if (null != l && l != lastNode) {
				lastNode = null;
				stack.push(l);
				result.add(l.val);
				continue;
			}

			// 5 : traverse right node .			
			if (null != r) {
				lastNode = null;
				stack.push(r);
				result.add(r.val);
				continue;
			}
		}
		return result;
	}
	
	
	public static List<Integer> inorderTraverse(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>(); 
		stack.push(root);
		
		// record the recent popped node.
		TreeNode lastNode = null;  
		while (stack.isEmpty() == false) {
			TreeNode rt = stack.lastElement();
			TreeNode l = rt.left;
			TreeNode r = rt.right;
			
			/*
			 * case 1. rt is leaf node, pop.
			 * case 2. left child has been traversed and no right child exist, pop. nor see case 5.
			 * case 3. right child has been traversed , pop.
			 * case 4. left child has not been traversed, add to stack.
			 * case 5. right child has not been traversed, add to stack.
			 */
			
			// 1 : check whether node rt is a leaf node.
			if (l == null && r == null) {
				lastNode = rt;
				stack.pop();
				result.add(rt.val);
				continue;
			}
			
			// 2 : check whether node rt's left node has been traversed completely.
			if (l != null && lastNode == l && null == r) {
				lastNode = rt;
				stack.pop();
				result.add(rt.val);
				continue;
			}
			
			// 3 : check whether node rt's right node has been traversed completely.
			if (r != null && lastNode == r) {
				lastNode = rt;
				stack.pop();
				continue;
			}
			
			// 4 : traverse left node .
			if (null != l && l != lastNode) {
				lastNode = null;
				stack.push(l);
				continue;
			}

			// 5 : traverse right node .			
			if (null != r) {
				lastNode = null;
				stack.push(r);
				continue;
			}
		}
		return result;
	}	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		makeTreeData(root);
		List<Integer> preorder = preorderTraverse(root);
		System.out.println(preorder);
		List<Integer> inorder = inorderTraverse(root);
		System.out.println(inorder);
	}
	
	public static void makeTreeData(TreeNode root) {
		if (null == root) {
			throw new IllegalArgumentException("root should not be null.");
		}
		if (root.val > 10) {
			return;
		}
		TreeNode left = new TreeNode(root.val * 2);
		makeTreeData(left);
		TreeNode right = new TreeNode(root.val * 2 + 1);
		makeTreeData(right);
		
		root.left = left;
		root.right = right;
	}

	public static void makeTreeData2(TreeNode root) {
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
	}
}
