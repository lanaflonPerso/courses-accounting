package com.intelisoft.courses.accounting.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.intelisoft.courses.accounting.api.dao.ICourseDao;
import com.intelisoft.courses.accounting.api.services.ICourseService;
import com.intelisoft.courses.accounting.dao.CourseDaoImpl;
import com.intelisoft.courses.accounting.models.Course;
import com.intelisoft.courses.accounting.utils.HibernateUtil;

public class CourseServiceImpl implements ICourseService {

	private static final Logger log = Logger.getLogger(CourseServiceImpl.class);

	ICourseDao dao = new CourseDaoImpl();

	public List<Course> getCoursesWithLessons() {

		Session session = HibernateUtil.getSession();

		session.beginTransaction();

		List<Course> courses = null;

		try {

			courses = dao.getAll(session);

			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error("Error in service, getCoursesWithLessons method", e);
		}

		return (List<Course>) courses;

	}

}
