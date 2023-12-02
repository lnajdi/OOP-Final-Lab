classDiagram
    class Jury {
        +List<MembreJury> membres
    }
    class MembreJury {
        +String role
        +List<Domaine> responsabilites
    }
    class Personne {
        +String nom
        +String contact
    }
    class Hackathon {
        +String nom
        +Date date
        +String lieu
        +List<Equipe> equipes
        +List<Sponsor> sponsors
        +String theme
    }
    class Equipe {
        +String nom
        +List<Etudiant> membres
        +Projet projet
        +Discours presentation
    }
    class Etudiant {
        +String universite
        +List<Competence> competences
        +String nomEquipe
    }
    class Discours {
        +String sujet
        +String orateur
        +DateTime heure
    }
    
    Personne <|-- MembreJury : Herite
    Personne <|-- Etudiant : Herite
    Hackathon -- Equipe : comprend
    Jury -- MembreJury : compose de
    Equipe -- Etudiant : constitue de
    Equipe -- Discours : presente
