-- USERS TABLE
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- Encrypted password
    department VARCHAR(50) NOT NULL, -- Role or department (e.g., admin, faculty)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert users
INSERT INTO users (username, password, department) VALUES
('Karthik', ' $2a$10$UjDQ2VcrxZqrhmcY.Ocrz.vo.UlsKWhzS9oK9xR6M5AXsdV8p2TIK', 'admin'),
('Swaroop', ' $2a$10$OnRcZZQBCWWof9.z5DDuiOf6/akPkdckEX2RgC0ZMod37fs0hq2fS', 'employee');

-- COURSES TABLE
CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    course_code VARCHAR(20) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    year INT NOT NULL,
    term VARCHAR(20) NOT NULL,
    faculty VARCHAR(100) NOT NULL,
    credits INT NOT NULL,
    capacity INT NOT NULL,
);

-- Insert courses
INSERT INTO courses (name, course_code, description, year, term, faculty, credits, capacity) VALUES
('Software Engineering', 'SE101', 'Introduction to software engineering principles.', 2024, 'Spring', 'Dr. Smith', 4, 50),
('Data Structures', 'DS102', 'Comprehensive study of data structures.', 2024, 'Fall', 'Dr. Johnson', 3, 40),
('Algorithms', 'ALG103', 'In-depth study of algorithms.', 2024, 'Fall', 'Dr. Lee', 4, 40),
('Database Systems', 'DB104', 'Understanding database design and queries.', 2024, 'Spring', 'Dr. Taylor', 3, 35);

INSERT INTO course_entity (name, course_code, description, year, term, faculty, credits, capacity) VALUES
('Operating Systems', 'OS105', 'Study of operating systems and process management.', 2024, 'Fall', 'Dr. White', 4, 45),
('Computer Networks', 'CN106', 'Understanding network protocols and architectures.', 2024, 'Spring', 'Dr. Green', 3, 50),
('Machine Learning', 'ML107', 'Introduction to machine learning algorithms.', 2024, 'Fall', 'Dr. Blue', 4, 30),
('Artificial Intelligence', 'AI108', 'Foundations of artificial intelligence.', 2024, 'Spring', 'Dr. Brown', 4, 25),
('Cybersecurity', 'CY109', 'Study of cybersecurity principles and practices.', 2024, 'Fall', 'Dr. Black', 3, 35),
('Web Development', 'WD110', 'Design and development of web applications.', 2024, 'Spring', 'Dr. Yellow', 3, 40);


-- PREREQUISITES TABLE
CREATE TABLE prerequisites (
    course_id BIGINT NOT NULL,
    prerequisite_id BIGINT NOT NULL,
    PRIMARY KEY (course_id, prerequisite_id),
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE,
    FOREIGN KEY (prerequisite_id) REFERENCES courses(id) ON DELETE CASCADE
);

-- Insert prerequisites
INSERT INTO course_pre_requisite_entity (course_id, prerequisite_id, description) VALUES
(3, 2, 'ALG103 builds upon concepts learned in DS102'),     -- Algorithms requires Data Structures
(10, 6, 'WD110 requires foundational knowledge from CN106'), -- Web Development requires Computer Networks
(8, 7, 'AI108 requires concepts from ML107'),               -- Artificial Intelligence requires Machine Learning
(9, 1, 'CY109 requires understanding of SE101');            -- Cybersecurity requires Software Engineering
