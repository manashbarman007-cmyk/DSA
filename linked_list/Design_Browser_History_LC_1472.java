package linked_list;

// implementing a DLL
class BrowserNode {
    String data;
    BrowserNode next;
    BrowserNode back;

    BrowserNode (String data, BrowserNode next, BrowserNode back) {
        this.data = data;
        this.next = next;
        this.back = back;
    }

    BrowserNode (String data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class Design_Browser_History_LC_1472 {
    public static void main(String[] args) {

    }
}


class BrowserHistory {
    BrowserNode currentNode;
    // class constructor
    public BrowserHistory(String homepage) {
        currentNode = new BrowserNode(homepage); // we create a new node for the homepage, as it will be the first node
    }

    public void visit(String url) {
        BrowserNode newNode = new BrowserNode(url);
        currentNode.next = newNode;
        newNode.back = currentNode;
        currentNode = newNode;
    }

    public String back(int steps) {
        while (steps > 0) {
            if (currentNode.back != null) {
                currentNode = currentNode.back;
            }
            else {
                break; // we get out of the loop and return whatever is in the currentNode
            }
            steps--;
        }
        return  currentNode.data;
    }

    public String forward(int steps) {
        while (steps > 0) {
            if (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            else {
                break; // we get out of the loop and return whatever is in the currentNode
            }
            steps--;
        }
        return currentNode.data;
    }
}
