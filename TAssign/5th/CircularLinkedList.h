//
// Created by TaniaAggarwal on 5/5/2021.
//

#include <iostream>
using namespace std;

/*
 * Circular Linked List from PA2
 */

//Node for Circular Doubly-Linked list
template <class T>
class Node{
public:
    T data;
    Node<T>* next;
    Node<T>* prev;
};

template <class T>
class CircularLinkedList {
public:
    Node<T>* head;
    Node<T>* tail;

    CircularLinkedList(){
        head = nullptr;
        tail = nullptr;
    }

    bool is_empty();
    Node<T>* insert_at_head(T);
    Node<T>* insert_at_tail(T);
    Node<T>* delete_at_head();
    Node<T>* delete_at_tail();
    int get_length();
    T get_head_element();
    T get_tail_element();
    Node<T>* get_head_node();
    Node<T>* get_tail_node();
    void insert_at_pos(int, T);
    void delete_at_pos(int);
    bool search(T);
    void display();
};

//function to check if the linked list is empty -> returns bool value - true or false
template <class T>
bool CircularLinkedList<T> :: is_empty() {
    if (head == nullptr)
        return true;
    return false;
}

//function to add node at head -> returns new node
template <class T>
Node<T>* CircularLinkedList<T> :: insert_at_head(T val) {

    //create new node
    Node<T>* new_node = new Node<T>;
    new_node->data = val;

    //if the list is empty initially
    if (is_empty())
    {
        head = tail = new_node;
        new_node->next = head;
        new_node->prev = tail;
    }
    else
    {
        new_node->next = head;
        new_node->prev = head->prev;
        tail->next = new_node;
        head->prev = new_node;
        head = new_node;
    }
    return new_node;
}

//function to add node at tail -> returns new node
template <class T>
Node<T>* CircularLinkedList<T> :: insert_at_tail(T val) {

    //create new node
    Node<T>* new_node = new Node<T>;
    new_node->data = val;

    //if list is empty initially
    if (is_empty()){
        head = tail = new_node;
        new_node->next = head;
        new_node->prev = tail;
    }
    else
    {
        new_node->next = head;
        new_node->prev = tail;
        tail->next = new_node;
        head->prev = new_node;
        tail = new_node;
    }
    return new_node;
}

//function to delete head node -> returns new head after deletion
template <class T>
Node<T>* CircularLinkedList<T> :: delete_at_head() {

    //if the list is empty initially
    if (is_empty()){
        cout<<"Empty Already.\n";
        return nullptr;
    }
    //if there's just one node in the list
    else if (head == tail) {
        free(head);
        head = tail = nullptr;
        return nullptr;
    }
    head->next->prev = tail;
    tail->next = head->next;
    delete head;
    head = tail->next;
    return head;
}

//function to delete tail node -> returns new tail after deletion
template <class T>
Node<T>* CircularLinkedList<T> :: delete_at_tail() {

    //if the list is empty initially
    if (is_empty()) {
        cout<<"List is already empty.\n";
        return nullptr;
    }
        //if the list contains just one node
    else if (head == tail) {
        free(tail);
        head = tail = NULL;
        return nullptr;
    }
    tail->prev->next = head;
    head->prev = tail->prev;
    delete tail;
    tail = head->prev;
    return tail;
}

//function to search for a data value in linked list -> returns true if found, else false.
template <class T>
bool CircularLinkedList<T> :: search(T val) {

    //if the list is empty
    if(is_empty()) {
        cout<<"List is empty.\n";
        return false;
    }
    //initialize temp from head
    Node<T>* temp = head;

    //iterate through list until the element is found, or tail is encountered.
    while (true)
    {
        if (temp->data == val)
            return true;
        if (temp == tail)
            return false;
        temp = temp->next;
    }
}

//function to display elements of linked list (forward traversal)
template <class T>
void CircularLinkedList<T> :: display() {

    //if the list is empty
    if (is_empty()) {
        cout<<"Empty!\n";
        return;
    }
    //initialize temp with head
    Node<T>* temp = head;
    //iterate through the list until tail is encountered.
    while(true)
    {
        cout<<temp->data<<endl;
        if (temp == tail)
            return;
        temp = temp->next;
    }
}

//function to find the length(no. of elements) of linked list -> returns int value
template <class T>
int CircularLinkedList<T> :: get_length() {

    //if list is empty
    if (is_empty())
        return 0;
    int count = 1;
    //iterate through loop and keep incrementing count until tail is reached.
    Node<T>* temp = head;
    while(temp != tail)
    {
        temp = temp->next;
        count++;
    }
    return count;
}

//Function to insert new node at given position
template <class T>
void CircularLinkedList<T> :: insert_at_pos(int pos, T val) {

    //position should not be less than 1
    if (pos < 1)
        cout<<"Invalid position.\n";

        //if given position is greater than the length of list, add node at the end
    else if (pos >= get_length())
        insert_at_tail(val);

        //if position is 1, add node at the beginning
    else if (pos == 1)
        insert_at_head(val);

    else {
        int count = 1;
        Node<T>* temp = head;
        Node<T>* new_node = new Node<T>;
        new_node->data = val;
        while(count < pos-1){
            temp = temp->next;
            count++;
        }
        new_node->prev = temp;
        new_node->next = temp->next;
        temp->next->prev = new_node;
        temp->next = new_node;
    }

}

//Function to delete node from given position
template <class T>
void CircularLinkedList<T> :: delete_at_pos(int pos) {

    //position cannot be less than 1 or greater than the length of list
    if (pos<1 || pos>get_length())
        cout<<"Invalid position.\n";

        //if position is 1, that means head node is to be deleted
    else if (pos == 1)
        delete_at_head();

        //if position is equal to length of list, that means tail is to be deleted
    else if (pos == get_length())
        delete_at_tail();

    else {
        int count = 1;
        Node<T>* temp = head;
        while (count < pos) {
            temp = temp->next;
            count++;
        }
        temp->prev->next = temp->next;
        temp->next->prev = temp->prev;
        free(temp);
    }
}

//Function to return data of head node
template <class T>
T CircularLinkedList<T> :: get_head_element() {
    return head->data;
}

template<class T>
T CircularLinkedList<T>::get_tail_element() {
    return tail->data;
}

template<class T>
Node<T> *CircularLinkedList<T>::get_head_node() {
    return head;
}

template<class T>
Node<T> *CircularLinkedList<T>::get_tail_node() {
    return tail;
}
