package one.digitalinnovation.personapi;

import one.digitalinnovation.personapi.service.Person;

interface PersonRepository extends JpaRepository<Person, Long> {
}