# 🧠 SkillLedger: Personal Learning Tracker

> “Track your learning like you track your code.”

**SkillLedger** is a full-stack enterprise application designed for developers and lifelong learners to organize, measure, and visualize their personal learning journeys.  
Built using **Spring Boot**, **React**, and **PostgreSQL**, SkillLedger integrates with popular learning platforms to centralize your progress across courses, tutorials, and certifications.

---

## 🚀 Features

### 🎯 Learning Management
- Create, update, and delete personalized learning goals.
- Categorize goals by technology, framework, or certification.
- Set target completion dates and progress milestones.

### 📅 Progress Logging
- Record daily or weekly learning sessions.
- Track hours spent and personal reflections.
- Auto-calculate completion percentages per goal.

### 🌐 External Platform Integration
- Connecting APIs from **Coursera**, **Udemy**, and **YouTube**.
- Automatically import enrolled course metadata and progress.
- Background sync job (Spring Scheduler) updates every 24 hours.

### 📊 Analytics Dashboard
- Interactive charts powered by **Chart.js / Recharts**.
- Visualize:
  - Hours spent per skill category
  - Weekly learning trends
  - Planned vs. actual goal completion
- Export analytics as PDF or CSV.

### 📧 Smart Notifications
- Automated reminders for inactive goals.
- Weekly email summaries with learning stats.
- Built with **Spring Mail** and **Quartz Scheduler**.

---
