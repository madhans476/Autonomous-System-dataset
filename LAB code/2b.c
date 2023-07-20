#include <stdio.h>
#include <stdlib.h>

// Define the node structure
struct node {
    int data;
    struct node* next;
};

// Function to create a new node
struct node* create_node(int data) {
    struct node* new_node = (struct node*)malloc(sizeof(struct node));
    new_node->data = data;
    new_node->next = NULL;
    return new_node;
}

// Function to insert a new node in sorted order
void insert_sort(struct node** head, struct node* element) {
    if (*head == NULL || element->data < (*head)->data) {
        element->next = *head;
        *head = element;
    } else {
        struct node* current = *head;
        while (current->next != NULL && current->next->data < element->data) {
            current = current->next;
        }
        element->next = current->next;
        current->next = element;
    }
}

// Function to display the linked list
void display(struct node* head) {
    struct node* current = head;
    while (current) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");
}

// Function to free the memory occupied by the linked list
void free_list(struct node* head) {
    struct node* current = head;
    while (current) {
        struct node* temp = current;
        current = current->next;
        free(temp);
    }
}

// Example usage
int main() {
    struct node* head = NULL;
    insert_sort(&head, create_node(12));
    insert_sort(&head, create_node(9));
    insert_sort(&head, create_node(20));
    insert_sort(&head, create_node(4));
    printf("Sorted Linked List is: ");
    display(head);

    insert_sort(&head, create_node(1));

    printf("Sorted Linked List after adding the new element: ");
    display(head);

    // Free the memory used by the linked list
    free_list(head);

    return 0;
}