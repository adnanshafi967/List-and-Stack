public class ListStack implements Stack{
  int size;
  Node top;
  
  
  public ListStack(){
    size = 0;
    top = null;
  }
  
// The number of items on the stack
  public int size(){
    return size;
  }
// Returns true if the stack is empty
  public boolean isEmpty(){
    if(size==0){
      return true;
    }
    else{
      return false;
    }
  }
// Pushes the new item on the stack, throwing the
// StackOverflowException if the stack is at maximum capacity. It
// does not throw an exception for an "unbounded" stack, which
// dynamically adjusts capacity as needed.
  public void push(Object e) throws StackOverflowException{
    top =new Node(e,top);
    size++;
  }
// Pops the item on the top of the stack, throwing the
// StackUnderflowException if the stack is empty.
  public Object pop() throws StackUnderflowException{
    if(size==0){
      throw new StackUnderflowException();
    }
    else{
      Object t=top.val;
      top=top.next;
      size--;
      return t;
    }
  }
// Peeks at the item on the top of the stack, throwing
// StackUnderflowException if the stack is empty.
  public Object peek() throws StackUnderflowException{
    if(size==0){
      throw new StackUnderflowException();
    }
    return top.val;
  }
// Returns a textual representation of items on the stack, in the
// format "[ x y z ]", where x and z are items on top and bottom
// of the stack respectively.
  public String toString(){
    if(size==0){
        return "Empty Stack";
      }
    String s="";
    for(Node i=top;i!=null;i=i.next){
      s=s+" "+i.val;
    }
    return s;
  }
// Returns an array with items on the stack, with the item on top
// of the stack in the first slot, and bottom in the last slot.
  public Object[] toArray(){
    
    Object a[]= new Object[size];
    Node temp=top;
    for(int i=0;i<size;i++){
      a[i]=temp.val;
      temp=temp.next;
    }
    return a;
  }
// Searches for the given item on the stack, returning the
// offset from top of the stack if item is found, or -1 otherwise.
  public int search(Object e){
    int j=0;
    for(Node i=top;i!=null;i=i.next){
      if(i.val==e){
        return j;
      }
      j++;
    }
    return -1;
  }
}