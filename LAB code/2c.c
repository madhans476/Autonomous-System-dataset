#include <stdio.h>
#include <stdlib.h>

// Define the node structure
struct node {
    int data;
    struct node* next;
};

// Function to create a new node
struct node* Create_node(int data) {
    struct node* new_node = (struct node*)malloc(sizeof(struct node));
    new_node->data = data;
    new_node->next = NULL;
    return new_node;
}

// Function to insert a new node at the end (enqueue)
void insert_q(struct node** head, struct node* element) {
    if (*head == NULL) {
        *head = element;
    } else {
        struct node* current = *head;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = element;
    }
}

// Function to delete a node from the beginning (dequeue)
struct node* Delete_q(struct node** head) {
    if (*head == NULL) {
        printf("Queue is empty.\n");
        return NULL;
    }

    struct node* deleted_node = *head;
    *head = (*head)->next;
    deleted_node->next = NULL;
    return deleted_node;
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
    insert_q(&head, Create_node(1));
    insert_q(&head, Create_node(2));
    insert_q(&head, Create_node(3));
    insert_q(&head, Create_node(4));

    printf("Queue is : ");
    display(head);

    struct node* deleted_node = Delete_q(&head);
    if (deleted_node != NULL) {
        printf("Deleted Element is %d\n", deleted_node->data);
        free(deleted_node);
    }
    insert_q(&head, Create_node(0));
    printf("Updated Queue is : ");
    display(head);

    // Free the memory used by the linked list
    free_list(head);

    return 0;
}