#Query to display all employees within a specific project (referenced by project name)
# Available project names A, B, service, D, E

Select e.name from employees e,project_employee ep, projects p
where p.projectName= 'B'
  AND e.id=ep.employee_id
  And ep.project_id=p.id