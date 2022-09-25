static Node deleteBeg(Node head)
    {
        if(head == null)
            return null;
        if(head.next == null)
        {
            head = null;
            return null;
        }
        
        Node temp = head.next;
        head = null;
        temp.prev = null;
        return temp;
        
    }
    static Node deleteEnd(Node head)
    {
        if(head == null)
            return null;
        if(head.next == null)
        {
            head = null;
            return null;
        }   
        
        Node ptr = head;
        while(ptr.next.next != null)
        {
            ptr = ptr.next;
        }
        ptr.next = null;
        return head;
    }
    
    static Node deletePos(Node head, int pos)
    {
        if(head == null)
            return null;
        if(head.next == null && pos == 1)
        {
            head = null;
            return null;
        } 
        if(head.next == null && pos != 1)
        {
            System.out.println("Position does not exist.");
            return head;
        }
        int count = 0;
        Node ptr = head;
        while(ptr.next != null)
        {
            count++;
            
            if(count == pos && pos == 1)
            {
                head = deleteBeg(head);
                break;
            }
            if(count == pos)
            {
                if(ptr.next != null)
                    ptr.prev.next = ptr.next;
                else
                {
                    head = deleteEnd(head);
                    break;
                }
                ptr.next.prev = ptr.prev;
                break;
            }
            ptr = ptr.next;
        }
        return head;
        
    }