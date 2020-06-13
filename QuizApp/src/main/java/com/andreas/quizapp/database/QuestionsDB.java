package main.java.com.andreas.quizapp.database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Aggregates;
import main.java.com.andreas.quizapp.model.Question;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuestionsDB {
    public static List<Question> getRandomQuestions(String category) {
        List<Question> questions = new ArrayList<>();

        MongoCollection<Document> collection = ConnectDB.getDatabase().getCollection("quizQuestions");
        //MongoCursor<Document> cursor = collection.aggregate(Arrays.asList(Aggregates.sample(10), Aggregates.limit(10), Aggregates.match(new Document("category", category)))).iterator();
        MongoCursor<Document> cursor = collection.aggregate(Arrays.asList(Aggregates.match(new Document("category", category)))).iterator();
        try {
            do {
                Document doc = cursor.next();
                questions.add(new Question(doc.get("text").toString(), doc.get("responseA").toString(), doc.get("responseB").toString(), doc.get("responseC").toString(),
                        doc.get("responseD").toString(), doc.get("category").toString(), doc.get("answer").toString().charAt(0)));
            } while (cursor.hasNext());
        } finally {
            cursor.close();
        }

        Collections.shuffle(questions);
        return questions.subList(0,10);
    }

    public static List<Document> getBuiltInQuestions() {
        List<Document> documents = new ArrayList<Document>();

        //Art and Literature
        documents.add(new Document("category", "Art and Literature").append("text", "Which two cities provide the setting for Charles Dickens’s ‘A Tale of Two Cities’?")
                .append("responseA", "London and Paris").append("responseB", "Paris and Rome").append("responseC", "Madrid and Bucharest").append("responseD", "London and Athens").append("answer", 'A'));
        documents.add(new Document("category", "Art and Literature").append("text", "What are the names of the three ‘Darling’ children in J.M. Barrie’s ‘Peter Pan’?")
                .append("responseA", "Sarah, John and Michael").append("responseB", "Wendy, John and Michael").append("responseC", "Wendy, Ben and Kate").append("responseD", "Wendy, Richard and Anna").append("answer", 'B'));
        documents.add(new Document("category", "Art and Literature").append("text", "Which book of the New Testament comes after the four gospels of Matthew, Mark, Luke and John?")
                .append("responseA", "Epistles").append("responseB", "Pauline letters to churches").append("responseC", "Acts (of the Apostles)").append("responseD", "Hebrews").append("answer", 'C'));
        documents.add(new Document("category", "Art and Literature").append("text", "In which century was the Florentine painter known as Sandro Botticelli born?")
                .append("responseA", "17th century (born around 1645)").append("responseB", "15th century (born around 1440)").append("responseC", "16th century (born around 1545)").append("responseD", "15th century (born around 1445)").append("answer", 'D'));
        documents.add(new Document("category", "Art and Literature").append("text", "Which cartoon animal is owned by Jon Arbuckle?")
                .append("responseA", "Garfield (and Odie)").append("responseB", "Tom").append("responseC", "Goofy").append("responseD", "Bugs Bunny").append("answer", 'A'));
        documents.add(new Document("category", "Art and Literature").append("text", "In ‘The Hitchhiker’s Guide to the Galaxy’ by Douglas Adams, which character chose his name because “when he first arrived fifteen years ago, the minimal research he had done had suggested to him…” that it would be “… nicely inconspicuous”?")
                .append("responseA", "Marvin").append("responseB", "Ford Prefect").append("responseC", "Arthur Dent").append("responseD", "Random Dent").append("answer", 'B'));
        documents.add(new Document("category", "Art and Literature").append("text", "Who wrote the 1936 novel ‘Gone with the Wind’, on which the 1939 film of the same name was based?")
                .append("responseA", "Douglas Adams").append("responseB", "Victor Fleming").append("responseC", "Margaret Mitchell").append("responseD", "David Selznick").append("answer", 'C'));
        documents.add(new Document("category", "Art and Literature").append("text", "Which Shakespearean play features the characters of Goneril, Regan and Cordelia?")
                .append("responseA", "The Tempest").append("responseB", "Cymbeline").append("responseC", "The Winter's Tale").append("responseD", "King Lear").append("answer", 'D'));
        documents.add(new Document("category", "Art and Literature").append("text", "What is the first name of Professor McGonagall in the Harry Potter books?")
                .append("responseA", "Minerva").append("responseB", "McGonagall").append("responseC", "Maggie").append("responseD", "Smith").append("answer", 'A'));
        documents.add(new Document("category", "Art and Literature").append("text", "A Banksy painting of ‘Girl with Balloon’ self-shredded after selling at action in October. Where did this take place?")
                .append("responseA", "Tate Modern").append("responseB", "Sotheby’s").append("responseC", "National Gallery").append("responseD", "The Wallace Collection").append("answer", 'B'));
        documents.add(new Document("category", "Art and Literature").append("text", "Who served as Poet Laureate of the United Kingdom between October 1972 and May 1984?")
                .append("responseA", "John Bradley").append("responseB", "John Legend").append("responseC", "John Betjeman").append("responseD", "John Cleese").append("answer", 'C'));
        documents.add(new Document("category", "Art and Literature").append("text", "Which two types of animal were used as the mallets and balls at the Queen’s croquet ground in Lewis Carroll’s ‘Alice in Wonderland’?")
                .append("responseA", "Hedgehogs as mallets and flamingoes as balls").append("responseB", "Goats as mallets and hedgehogs as balls").append("responseC", "Flamingoes as mallets and frogs as balls").append("responseD", "Flamingoes as mallets and hedgehogs as balls").append("answer", 'D'));
        documents.add(new Document("category", "Art and Literature").append("text", "How old was Adrian Mole when he wrote his ‘Secret Diary’ according to Sue Townsend’s 1982 book?")
                .append("responseA", "Thirteen and two-quarters").append("responseB", "Sixteen and three-quarters").append("responseC", "Eighteen and three-quarters").append("responseD", "Thirteen and three-quarters").append("answer", 'D'));
        documents.add(new Document("category", "Art and Literature").append("text", "In which country would you find the State Hermitage Museum?")
                .append("responseA", "Russia").append("responseB", "USA").append("responseC", "Deutschland").append("responseD", "France").append("answer", 'A'));
        documents.add(new Document("category", "Art and Literature").append("text", "Who created the cartoon character ‘Garfield’?")
                .append("responseA", "Lorenzo Music").append("responseB", "Jim Davis").append("responseC", "Gary Owens").append("responseD", "Frank Buxton").append("answer", 'B'));
        documents.add(new Document("category", "Art and Literature").append("text", "In which modern-day country was Rembrandt born?")
                .append("responseA", "Luxemburg").append("responseB", "Belgium").append("responseC", "Netherlands").append("responseD", "Deutschland").append("answer", 'C'));
        documents.add(new Document("category", "Art and Literature").append("text", "‘A Bigger Splash’, ‘Mr and Mrs Clark and Percy’ and ‘Garrowby Hill’ are all paintings by which English artist?")
                .append("responseA", "Howard Hodgkin").append("responseB", "Henry Moore").append("responseC", "William Holman Hunt").append("responseD", "David Hockney").append("answer", 'D'));
        documents.add(new Document("category", "Art and Literature").append("text", "Published in 2017, ‘Only Fools and Stories’ is whose second autobiography?")
                .append("responseA", "David Jason").append("responseB", "Del Boy").append("responseC", "Turia Pitt").append("responseD", "Lisa Messenger").append("answer", 'A'));
        documents.add(new Document("category", "Art and Literature").append("text", "“Night is generally my time for walking.” This is the opening line to which novel by Charles Dickens ?")
                .append("responseA", "Oliver Twist").append("responseB", "The Old Curiosity Shop").append("responseC", "David Copperfield").append("responseD", "Little Dorrit").append("answer", 'B'));
        documents.add(new Document("category", "Art and Literature").append("text", "What is Frankenstein’s first name in Mary Shelley’s novel?")
                .append("responseA", "David").append("responseB", "John").append("responseC", "Victor").append("responseD", "Mike").append("answer", 'C'));

        //General Knowledge
        documents.add(new Document("category", "General Knowledge").append("text", "Where in the world would you expect to find a car with the vehicle registration code ‘V’?")
                .append("responseA", "Vatican City").append("responseB", "Valencia").append("responseC", "Vietnam").append("responseD", "Venezuela").append("answer", 'A'));
        documents.add(new Document("category", "General Knowledge").append("text", "In which children’s book did a spider called Charlotte and a pig called Wilbur appear?")
                .append("responseA", "Where the Wild Things Are").append("responseB", "Charlotte’s Web").append("responseC", "The Little Prince").append("responseD", "The Three Little Pigs").append("answer", 'B'));
        documents.add(new Document("category", "General Knowledge").append("text", "Which Mexican artist produced works entitled ‘The Broken Column’ and ‘Diego and I’?")
                .append("responseA", "Diego Rivera").append("responseB", "José Guadalupe Posada").append("responseC", "Frida Kahlo").append("responseD", "Manuel Álvarez Bravo").append("answer", 'C'));
        documents.add(new Document("category", "General Knowledge").append("text", "How many sides has a heptadecagon?")
                .append("responseA", "15").append("responseB", "16").append("responseC", "18").append("responseD", "17").append("answer", 'D'));
        documents.add(new Document("category", "General Knowledge").append("text", "What was the name of the character played by John Travolta in the film ‘Pulp Fiction’?")
                .append("responseA", "Vincent Vega").append("responseB", "The Gimp").append("responseC", "Zed").append("responseD", "Pumpkin").append("answer", 'A'));
        documents.add(new Document("category", "General Knowledge").append("text", "Which was the first James Bond film to feature Roger Moore in the title role?")
                .append("responseA", "Dr. No").append("responseB", "Live and Let Die").append("responseC", "Goldfinder").append("responseD", "Live and Let Die").append("answer", 'B'));
        documents.add(new Document("category", "General Knowledge").append("text", "‘Suncrisp’, ‘Golden Russet’ and ‘Braeburn’ are all varieties of which fruit?")
                .append("responseA", "Orange").append("responseB", "Mango").append("responseC", "Apple").append("responseD", "Melon").append("answer", 'C'));
        documents.add(new Document("category", "General Knowledge").append("text", "In which country would you find the coastal resort of Lara Beach?")
                .append("responseA", "Greece").append("responseB", "Italy").append("responseC", "Spain").append("responseD", "Turkey").append("answer", 'D'));
        documents.add(new Document("category", "General Knowledge").append("text", "In which century was the first ‘Grand National’ horse race?")
                .append("responseA", "19th century (1839)").append("responseB", "18th century (1839)").append("responseC", "19th century (1893)").append("responseD", "20th century (1939)").append("answer", 'A'));
        documents.add(new Document("category", "General Knowledge").append("text", "The letters of the word ‘allergy’ can be rearranged to form three other seven-letter words. Can you find all three of them?")
                .append("responseA", "Allergy, largely and regally").append("responseB", "Largely, gallery and regally").append("responseC", "Regally, allergy and gallery").append("responseD", "Gallery, largely and alergy").append("answer", 'B'));
        documents.add(new Document("category", "General Knowledge").append("text", "Who was the shortest-serving UK Prime Minister of the 20th century?")
                .append("responseA", "Edward Heath").append("responseB", "Harold Wilson").append("responseC", "Andrew Bonar Law").append("responseD", "Arthur Balfour").append("answer", 'C'));
        documents.add(new Document("category", "General Knowledge").append("text", "Which is the only letter in Scrabble to have a value of five points?")
                .append("responseA", "A").append("responseB", "Z").append("responseC", "I").append("responseD", "K").append("answer", 'D'));
        documents.add(new Document("category", "General Knowledge").append("text", "After which Dutch explorer was the island state of Tasmania named?")
                .append("responseA", "Abel Tasman").append("responseB", "Anton Colijn").append("responseC", "Jean Victor de Bruijn").append("responseD", "Hendrikus Albertus Lorentz").append("answer", 'A'));
        documents.add(new Document("category", "General Knowledge").append("text", "What is the product of the number of playing cards in a pack and the number of minutes in an hour?")
                .append("responseA", "3240 (54 X 60)").append("responseB", "3120 (52 X 60)").append("responseC", "3000 (50 X 60)").append("responseD", "3360 (56 X 60)").append("answer", 'B'));
        documents.add(new Document("category", "General Knowledge").append("text", "Tobermory is the capital of which Scottish island?")
                .append("responseA", "Skye").append("responseB", "Islya").append("responseC", "Mull").append("responseD", "Iona").append("answer", 'C'));
        documents.add(new Document("category", "General Knowledge").append("text", "Which London Underground line has the most stations?")
                .append("responseA", "Circle line").append("responseB", "Metropolitan line").append("responseC", "Victoria line").append("responseD", "District Line").append("answer", 'D'));
        documents.add(new Document("category", "General Knowledge").append("text", "‘Hand on Your Heart’, ‘Wouldn’t Change a Thing’ and ‘Tears on My Pillow’ were all tracks on which 1990 studio album by Kylie Minogue?")
                .append("responseA", "Enjoy Yourself").append("responseB", "Light Years").append("responseC", "Let's Get to It").append("responseD", "Rhythm of Love").append("answer", 'A'));
        documents.add(new Document("category", "General Knowledge").append("text", "Who wrote the books on which the series ‘Game of Thrones’ is based?")
                .append("responseA", "Kit Harington").append("responseB", "George R.R. Martin").append("responseC", "Isaac Hempstead Wright").append("responseD", "Alfie Allen").append("answer", 'B'));
        documents.add(new Document("category", "General Knowledge").append("text", "What is the national currency of Trinidad and Tobago?")
                .append("responseA", "Trinidad and Tobago Pound").append("responseB", "Trinidad and Tobago Euro").append("responseC", "Trinidad and Tobago Dollar").append("responseD", "Trinidad and Tobago Franc").append("answer", 'D'));
        documents.add(new Document("category", "General Knowledge").append("text", "How many football matches were played in total in the 2018 FIFA World Cup in Russia?")
                .append("responseA", "65").append("responseB", "60").append("responseC", "70").append("responseD", "64").append("answer", 'D'));

        //Science and Nature
        documents.add(new Document("category", "Science and Nature").append("text", "What does USB stand for when used to describe the connection standard used between computers and smartphones and their devices?")
                .append("responseA", "Universal Serial Bus").append("responseB", "Universal Series Bus").append("responseC", "Universal Serial Box").append("responseD", "Universal Storage Bucket").append("answer", 'A'));
        documents.add(new Document("category", "Science and Nature").append("text", "‘Zr’ is the symbol for which chemical element?")
                .append("responseA", "Zinc").append("responseB", "Zirconium").append("responseC", "Sodium").append("responseD", "Iridium").append("answer", 'B'));
        documents.add(new Document("category", "Science and Nature").append("text", "In which modern-day country was the physicist and chemist Marie Curie born?")
                .append("responseA", "France").append("responseB", "Italy").append("responseC", "Poland").append("responseD", "Germany").append("answer", 'C'));
        documents.add(new Document("category", "Science and Nature").append("text", "Which is the largest internal organ in the human body?")
                .append("responseA", "Heart").append("responseB", "Brain").append("responseC", "Tongue").append("responseD", "Liver").append("answer", 'D'));
        documents.add(new Document("category", "Science and Nature").append("text", "Which type of creature is a Barramundi?")
                .append("responseA", "Fish").append("responseB", "Dog").append("responseC", "Cat").append("responseD", "Horse").append("answer", 'A'));
        documents.add(new Document("category", "Science and Nature").append("text", "Which geological era came first: Mesozoic, Paleozoic, Cenozoic or Neoproterozoic?")
                .append("responseA", "Mesozoic").append("responseB", "Paleozoic").append("responseC", "Cenozoic").append("responseD", "Neoproterozoic").append("answer", 'B'));
        documents.add(new Document("category", "Science and Nature").append("text", "In which century was Sir Isaac Newton born?")
                .append("responseA", "16th century").append("responseB", "18th century").append("responseC", "17th century").append("responseD", "13th century").append("answer", 'C'));
        documents.add(new Document("category", "Science and Nature").append("text", "What was the first name of the American astronomer after whom the Hubble telescope was named?")
                .append("responseA", "Vera").append("responseB", "Carl").append("responseC", "George").append("responseD", "Edwin").append("answer", 'D'));
        documents.add(new Document("category", "Science and Nature").append("text", "Bill Gates is famous for being one of the founders of Microsoft, but who was the other co-founder?")
                .append("responseA", "Paul Allen").append("responseB", "George Allen").append("responseC", "Paul McCollum").append("responseD", "Chris Hughes").append("answer", 'A'));
        documents.add(new Document("category", "Science and Nature").append("text", "How many wings does a mosquito have?")
                .append("responseA", "Two").append("responseB", "Three").append("responseC", "Four").append("responseD", "Six").append("answer", 'A'));
        documents.add(new Document("category", "Science and Nature").append("text", "Where in the human body would the limbic system be found?")
                .append("responseA", "In the heart").append("responseB", "In the brain").append("responseC", "In the stomach").append("responseD", "In the mouth").append("answer", 'B'));
        documents.add(new Document("category", "Science and Nature").append("text", "Which type of mammal is a gelada?")
                .append("responseA", "Bat").append("responseB", "Kangaroo").append("responseC", "Monkey").append("responseD", "Elephant").append("answer", 'C'));
        documents.add(new Document("category", "Science and Nature").append("text", "Which part of the body is affected by Gorham’s Disease?")
                .append("responseA", "Liver").append("responseB", "Brain").append("responseC", "Heart").append("responseD", "Bones").append("answer", 'D'));
        documents.add(new Document("category", "Science and Nature").append("text", "What is the collective noun used for a group of grasshoppers?")
                .append("responseA", "A cloud").append("responseB", "A murder").append("responseC", "A colony").append("responseD", "A bloat").append("answer", 'A'));
        documents.add(new Document("category", "Science and Nature").append("text", "Of what is phonology the study?")
                .append("responseA", "Nature").append("responseB", "Sounds").append("responseC", "Productivity").append("responseD", "Images").append("answer", 'B'));
        documents.add(new Document("category", "Science and Nature").append("text", "“For every action there is an equal and opposite reaction.” Whose third law is this?")
                .append("responseA", "Albert Einstein").append("responseB", "Thomas Edison").append("responseC", "Sir Isaac Newton").append("responseD", "Henry Ford").append("answer", 'C'));
        documents.add(new Document("category", "Science and Nature").append("text", "The MMR vaccine protects against which three diseases?")
                .append("responseA", "Shingles").append("responseB", "Hepatitis A").append("responseC", "Meningococcal disease").append("responseD", "Measles, mumps and rubella").append("answer", 'D'));
        documents.add(new Document("category", "Science and Nature").append("text", "Which two letters of the alphabet make up the chemical symbol for mercury?")
                .append("responseA", "Hg").append("responseB", "Mr").append("responseC", "Mc").append("responseD", "Hr").append("answer", 'A'));
        documents.add(new Document("category", "Science and Nature").append("text", "An ‘epiphyte’ is an organism that grows on the surface of what?")
                .append("responseA", "A flower").append("responseB", "A plant").append("responseC", "An animal").append("responseD", "An insect").append("answer", 'B'));
        documents.add(new Document("category", "Science and Nature").append("text", "A ‘light breeze’ of between 4 and 7 miles per hour would read as which number on the Beaufort Wind Force scale?")
                .append("responseA", "0").append("responseB", "12").append("responseC", "6").append("responseD", "2").append("answer", 'D'));

        return documents;
    }

    public static boolean existsCategory(String category) {
        MongoCollection<Document> collection = ConnectDB.getDatabase().getCollection("quizQuestions");
        return collection.countDocuments(new Document("category", category)) >= 10 ;
    }

    public static boolean addQuestion (Document question) {
        try {
            MongoCollection<Document> collection = ConnectDB.getDatabase().getCollection("quizQuestions");
            collection.insertOne(question);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean editQuestion(Document oldQuestion, Document newQuestion) {
        try {
            MongoCollection collection = ConnectDB.getDatabase().getCollection("quizQuestions");
            collection.updateOne(oldQuestion, new Document("$set", newQuestion));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean deleteQuestion (Document question) {
        try {
            MongoCollection<Document> collection = ConnectDB.getDatabase().getCollection("quizQuestions");
            collection.deleteOne(question);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static List<String> getQuestions(String category) {
        List<String> questions = new ArrayList<>();
        MongoCollection<Document> collection = ConnectDB.getDatabase().getCollection("quizQuestions");
        MongoCursor<Document> cursor = collection.aggregate(Arrays.asList(Aggregates.match(new Document("category", category)))).iterator();
        try {
            if (cursor.hasNext()) {
                do {
                    Document doc = cursor.next();
                    questions.add(doc.get("text").toString());
                } while (cursor.hasNext());
            }
        } finally {
            cursor.close();
        }
        return questions;
    }

    public static Question getQuestion(String category, String text) {
        MongoCollection<Document> collection = ConnectDB.getDatabase().getCollection("quizQuestions");
        MongoCursor<Document> cursor = collection.aggregate(Arrays.asList(Aggregates.match(new Document("category", category).append("text", text)))).iterator();
        try {
            if (cursor.hasNext()) {
                Document doc = cursor.next();
                return new Question(doc.get("text").toString(), doc.get("responseA").toString(), doc.get("responseB").toString(), doc.get("responseC").toString(),
                        doc.get("responseD").toString(), doc.get("category").toString(), doc.get("answer").toString().charAt(0));
            }
        } finally {
            cursor.close();
        }
        return new Question();
    }
}
