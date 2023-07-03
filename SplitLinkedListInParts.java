//https://leetcode.com/problems/split-linked-list-in-parts/description/

public class SplitLinkedListInParts {
    
    public static ListNode[] splitListToParts(ListNode head, int k) {
        int size = size(head);

        //Compute the sizes of the sublists
        int sublist_size;
        int[] sublist_sizes = new int[k];
        if (size < k) {
            int sum = 0;
            for(int i = 0; i < k; i++) {
                if (sum < size) {
                    sublist_sizes[i] = 1;
                    sum++;
                } else {
                    sublist_sizes[i] = 0;
                }
            }
        } else {
            sublist_size = size / k;
            for(int i = 0; i < k; i++) {
                sublist_sizes[i] = sublist_size;
            }

            int sum = sum(sublist_sizes);
            outer: while (true) {
                for (int i = 0; i < k; i++) {
                    if (sum != size) {
                        sum++;
                        sublist_sizes[i]++;
                    } else {
                        break outer;
                    }
                }
            }
        }
        
        ListNode[] resArray = new ListNode[k];

        for(int i = 0; i < k; i++) {
            if (sublist_sizes[i] == 0) {
                break;
            }

            ListNode node = head;
            ListNode cutoffEnd = node;
            while (sublist_sizes[i] != 0) {
                head = head.next;
                if (sublist_sizes[i] != 1) {
                    cutoffEnd = cutoffEnd.next;
                }
                sublist_sizes[i]--;
            }
            cutoffEnd.next = null;
            resArray[i] = node;
        }

        return resArray;
    }

    private static int sum(int[] subparts) {
        int sum = 0;

        for(int i = 0; i < subparts.length; i++) {
            sum += subparts[i];
        }
        return sum;
    }

    private static int size(ListNode head) {
        int counter = 0;

        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }
}
