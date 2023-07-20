#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define the Student structure
struct Student {
    int stdent_regno;
    char name[100];
    int age;
    struct Student* next;
};

// Function to create a new Student node
struct Student* create_student(int stdent_regno, const char* name, int age) {
    struct Student* new_student = (struct Student*)malloc(sizeof(struct Student));
    new_student->stdent_regno = stdent_regno;
    strcpy(new_student->name, name);
    new_student->age = age;
    new_student->next = NULL;
    return new_student;
}

// Function to display the linked list of Students
void display(struct Student* head) {
    struct Student* current = head;
    while (current) {
        printf("Register no: %d, Name: %s, Age: %d\n", current->stdent_regno, current->name, current->age);
        current = current->next;
    }
}

// Function to insert a new Student node at the front of the linked list
void insert_front(struct Student** head, int stdent_regno, const char* name, int age) {
    struct Student* new_student = create_student(stdent_regno, name, age);
    new_student->next = *head;
    *head = new_student;
}

// Function to insert a new Student node at the end of the linked list
void insert_end(struct Student** head, int stdent_regno, const char* name, int age) {
    struct Student* new_student = create_student(stdent_regno, name, age);
    if (*head == NULL) {
        *head = new_student;
    } else {
        struct Student* current = *head;
        while (current->next) {
            current = current->next;
        }
        current->next = new_student;
    }
}

// Function to insert a new Student node after a given Student ID in the linked list
void insert_after(struct Student* prev_student, int stdent_regno, const char* name, int age) {
    if (prev_student == NULL) {
        printf("Previous Student node is NULL.\n");
        return;
    }

    struct Student* new_student = create_student(stdent_regno, name, age);
    new_student->next = prev_student->next;
    prev_student->next = new_student;
}

// Function to delete a Student node with a given Student ID from the linked list
void delete(struct Student** head, int stdent_regno) {
    if (*head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Student* current = *head;
    struct Student* prev = NULL;

    if (current->stdent_regno == stdent_regno) {
        *head = current->next;
        free(current);
        return;
    }

    while (current) {
        if (current->stdent_regno == stdent_regno) {
            prev->next = current->next;
            free(current);
            return;
        }
        prev = current;
        current = current->next;
    }

    printf("Student with ID %d not found.\n", stdent_regno);
}

// Function to free the memory occupied by the linked list
void free_list(struct Student* head) {
    struct Student* current = head;
    while (current) {
        struct Student* temp = current;
        current = current->next;
        free(temp);
    }
}

// Helper function to create a sample linked list
struct Student* create_sample_linked_list() {
    struct Student* head = NULL;
    insert_front(&head, 1, "Gopal", 20);
    

    // Get the node with stdent_regno 101
    struct Student* prev_student = head;
    while (prev_student && prev_student->stdent_regno != 1) {
        prev_student = prev_student->next;
    }

    insert_after(prev_student, 2, "Bharath", 19);
    return head;
}

// Example usage
int main() {
    struct Student* head = create_sample_linked_list();
    display(head);
    
    delete(&head, 1);
    printf("After deleting student 1.\n");
    display(head);

    // Free the memory used by the linked list
    free_list(head);

    return 0;
}