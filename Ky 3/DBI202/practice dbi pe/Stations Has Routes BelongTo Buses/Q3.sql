--Q3
select e.employeeNumber, e.lastName + ' ' + e.firstName as employeesFullName, 
e.jobTitle, o.officeCode, o.city as officeCity, o.[state] as officeState, o.country as officeCountry from employees e
join offices o on e.officeCode = o.officeCode
where (o.country = 'USA ' or o.country = 'France')
order by o.country asc, o.city asc, e.employeeNumber asc