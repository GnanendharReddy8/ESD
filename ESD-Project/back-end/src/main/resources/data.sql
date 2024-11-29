-- Insert users
INSERT INTO users (username, password, department) VALUES
('Karthik', ' $2a$10$UjDQ2VcrxZqrhmcY.Ocrz.vo.UlsKWhzS9oK9xR6M5AXsdV8p2TIK', 'admin'),
('Raghav', '$2a$10$G97pQgEc3Tfkrk/An3os4OhKtXPytcOHAgvlFZqwX8EEJnW3RwtU.', 'admin');

-- Insert courses
INSERT INTO courses (name, course_code, description, year, term, faculty, credits, capacity) VALUES
('Software Engineering', 'SE101', 'Introduction to software engineering principles.', 2024, 'Spring', 'Dr. Smith', 4, 50),
('Data Structures', 'DS102', 'Comprehensive study of data structures.', 2024, 'Fall', 'Dr. Johnson', 3, 40),
('Algorithms', 'ALG103', 'In-depth study of algorithms.', 2024, 'Fall', 'Dr. Lee', 4, 40),
('Database Systems', 'DB104', 'Understanding database design and queries.', 2024, 'Spring', 'Dr. Taylor', 3, 35);

-- Insert prerequisites
INSERT INTO course_pre_requisite_entity (course_id, prerequisite_id, description) VALUES (9, 10, 'DS is prerequisite for SE');
INSERT INTO course_pre_requisite_entity (course_id, prerequisite_id, description) VALUES (12, 10, 'DS is prerequisite for DBMS');
INSERT INTO course_pre_requisite_entity (course_id, prerequisite_id, description) VALUES (11, 10, 'DS is prerequisite for Algorithms');
INSERT INTO course_pre_requisite_entity (course_id, prerequisite_id, description) VALUES (9, 11, 'Algorithms is prerequisite for SE');
