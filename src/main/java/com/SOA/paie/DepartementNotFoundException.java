package com.SOA.paie;

class DepartementNotFoundException extends RuntimeException  {
     DepartementNotFoundException(Long id) {
         super("Could not find employee " + id);
}}
