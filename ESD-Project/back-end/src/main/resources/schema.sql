-- USERS TABLE
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL, -- Encrypted password
    department VARCHAR(50) NOT NULL, -- Role or department (e.g., admin, faculty)
);

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

-- PREREQUISITES TABLE
CREATE TABLE prerequisites (
    course_id BIGINT NOT NULL,
    prerequisite_id BIGINT NOT NULL,
    PRIMARY KEY (course_id, prerequisite_id),
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE,
    FOREIGN KEY (prerequisite_id) REFERENCES courses(id) ON DELETE CASCADE
);
