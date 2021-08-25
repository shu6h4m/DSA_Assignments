#include "CircularLinkedList.h"
#include <iostream>
using namespace std;

/* IMPLEMENTING QUEUE ADT USING CIRCULAR LINKED LIST */

template <class T>
class Queue {
    Node<T>* front;
    Node<T>* rear;
    int size;
    CircularLinkedList<T> l1;

public:
    Queue();
    bool is_empty();
    void enqueue(T val);
    T dequeue();
    T Front();
    void display();
};

template<class T>
Queue<T>::Queue() {
    front = l1.get_head_node();
    rear = l1.get_tail_node();
    size = 0;
}

// function to check if queue is empty
template<class T>
bool Queue<T>::is_empty() {
    if (front == nullptr)
        return true;
    return false;
}

// function to add element at rear end of queue
template<class T>
void Queue<T>::enqueue(T val) {

    if (is_empty())
        front = rear = l1.insert_at_tail(val);
    else
        rear = l1.insert_at_tail(val);

    size++;
}

// function to remove element from front end of queue
template<class T>
T Queue<T>::dequeue() {

    T item;
    if (is_empty()) {
        throw string("Queue is already empty! Cannot delete item.");
    } else if (front == rear) {
        item = l1.get_head_element();
        front = l1.delete_at_head();
        rear = nullptr;
    }
    else {
        item = l1.get_head_element();
        front = l1.delete_at_head();
    }
    size--;
    return item;
}

// function to display queue
template<class T>
void Queue<T>::display() {
    l1.display();
}

// function to display the front element of queue
template<class T>
T Queue<T>::Front() {
    return l1.get_head_element();
}


/* CLASS TO IMPLEMENT STORING OF CALL REQUESTS IN QUEUE */

class CallRequests {
        Queue<string> waiting_queue;
    public:
        void make_request(string name);
        void request_served();
        void display_queue();
        string call_to_be_served();
};

// function to add request to queue
void CallRequests::make_request(string name) {
    waiting_queue.enqueue(name);
}

// function to remove request from queue
void CallRequests::request_served() {
    waiting_queue.dequeue();
}

// function to display all the elements of queue
void CallRequests::display_queue() {
    waiting_queue.display();
}

// function to check the first element of queue
string CallRequests::call_to_be_served() {
    return waiting_queue.Front();
}

// DRIVER CODE
int main() {

    CallRequests cr;
    string name;
    while (true) {
        cout << "\nMENU: \n1. Make a request \n2. Request Served \n3. Check next customer to be served \n4. Display waiting queue \n5. Quit. \nEnter choice: ";
        int choice;
        cin >> choice;

        switch (choice) {
            case 1:
                cout<<"Enter the name of customer: ";
                cin>>name;
                cr.make_request(name);
                cout<<"Request Added! \n";
                break;
            case 2:
                cr.request_served();
                cout<<"Request removed from Queue! \n";
                break;
            case 3:
                cout<<"Customer at the front of Queue: "<<cr.call_to_be_served()<<endl;
                break;
            case 4:
                cout<<"Waiting Queue: \n";
                cr.display_queue();
                break;
            case 5:
                return 0;
            default:
                cout<<"Invalid choice! \n";
        }
    }
}
