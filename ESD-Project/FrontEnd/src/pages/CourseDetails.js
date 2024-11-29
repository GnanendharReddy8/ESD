import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getCourseById, deleteCourse } from '../services/api';

const CourseDetails = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [course, setCourse] = useState(null);
  const [notification, setNotification] = useState(''); // New notification state

  useEffect(() => {
    getCourseById(id)
      .then((response) => setCourse(response.data))
      .catch(() => {
        alert('Course not found');
        navigate('/'); // Redirect back to home page
      });
  }, [id, navigate]);

  const handleDelete = () => {
    deleteCourse(id)
      .then(() => {
        setNotification('Course Deleted Successfully'); // Set success message
        setTimeout(() => {
          setNotification(''); // Clear message after 3 seconds
          navigate('/'); // Redirect after deletion
        }, 3000);
      })
      .catch((error) => console.error(error)); // Handle deletion errors
  };

  if (!course) return <div> </div>;

  return (
    <div className="course-details">
      <h1>{course.name}</h1>
      <p><strong>Code:</strong> {course.courseCode}</p>
      <p><strong>Description:</strong> {course.description}</p>
      {notification && <div className="notification">{notification}</div>} {/* Notification */}
      <div className="button-group">
        <button onClick={() => navigate('/')}>Back</button>
        <button onClick={() => navigate(`/course/update/${id}`)}>Edit</button>
        <button className="button-danger" onClick={handleDelete}>Delete</button>
      </div>
    </div>
  );
};

export default CourseDetails;
