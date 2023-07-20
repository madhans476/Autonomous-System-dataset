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

// Function to insert a new node at the end of the linked list
void insert_end(struct node** head, int data) {
    struct node* new_node = create_node(data);
    if (*head == NULL) {
        *head = new_node;
    } else {
        struct node* current = *head;
        while (current->next) {
            current = current->next;
        }
        current->next = new_node;
    }
}

// Function to concatenate two linked lists
struct node* concatenate(struct node* head1, struct node* head2) {
    if (head1 == NULL) {
        return head2;
    }
    if (head2 == NULL) {
        return head1;
    }

    struct node* new_head = head1;
    while (head1->next) {
        head1 = head1->next;
    }
    head1->next = head2;

    return new_head;
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
    struct node* head1 = NULL;
    struct node* head2 = NULL;

    insert_end(&head1, 001);
    insert_end(&head1, 002);
    insert_end(&head1, 003);

    insert_end(&head2, 004);
    insert_end(&head2, 005);
    insert_end(&head2, 006);

    printf("List 1: ");
    display(head1);

    printf("List 2: ");
    display(head2);

    struct node* new_list = concatenate(head1, head2);

    printf("Concatenated List are: ");
    display(new_list);

    // Free the memory used by the linked lists
    free_list(head1);
    free_list(head2);
    free_list(new_list);

    return 0;
}