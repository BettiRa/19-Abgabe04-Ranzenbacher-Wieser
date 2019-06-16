package at.fhj.iit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

    public class StringQueueTest {
        private StringQueue sq1;
        private StringQueue sq2;
        private static int maxSizeTestParameter = 2;

        /**
         * Initilize two instances of {@link StringQueue}.
         */
        @Before
        public void setUp() {
            sq1= new StringQueue();
            sq2 = new StringQueue(maxSizeTestParameter);
        }

        /**
         * Reset the two instances of {@link StringQueue}.
         */
        @After
        public void tearDown(){
            sq1=null;
            sq2=null;
        }

        /**
         * Tests with the default constructor (maxSize=5).
         * @result Return true because passing one String.
         */
        @Test
        public void offer() {

            assertTrue( sq1.offer("1"));
        }

        /**
         * Tests with the default constructor (maxSize=5).
         * @result Is false beacause passing six Strings.
         */
        @Test
        public void offer2() {
            sq1.offer("1");
            sq1.offer("2");
            sq1.offer("3");
            sq1.offer("4");
            sq1.offer("5");
            assertFalse( sq1.offer("6"));
        }

        /**
         * Tests with the second constructor maxSize is passed as argument (2).
         * @result Is true because passing two Strings.
         */
        @Test
        public void offer3() {
            sq2.offer("1");
            assertTrue( sq2.offer("2"));
        }

        /**
         * Tests with the second constructor maxSize is passed as argument (2).
         * @result Is false because passing three Strings.
         */
        @Test
        public void offer4() {
            sq2.offer("1");
            sq2.offer("2");
            assertFalse( sq2.offer("3"));
        }

        /**
         * Tests polling from empty instance of {@link StringQueue}.
         * @result Is null, because the queue is empty.
         */
        @Test
        public void poll() {

            assertNull(sq1.poll());
        }

        /**
         * Tests polling from the instance of {@link StringQueue} with an element.
         * @result Return true, because the queue is not empty.
         */
        @Test
        public void poll2() {
            sq1.offer("1");
            assertNotNull(sq1.poll());
        }

        /**
         * Tests polling from the instance of {@link StringQueue}, after {@link StringQueue#offer(String)} and {@link StringQueue#remove()}ing one element.
         * @result Is null, because the queue is empty.
         */
        @Test
        public void poll3() {
            sq1.offer("1");
            sq1.poll();
            assertNull(sq1.poll());
        }

        /**
         * Tests polling from the instance of {@link StringQueue}, after {@link StringQueue#offer(String)} and {@link StringQueue#remove()}ing two element.
         * @result Is null, because the queue is empty.
         */
        @Test
        public void poll4() {
            for(int i=0; i<maxSizeTestParameter; i++){
                sq2.offer(String.valueOf(i));
            }
            for(int i=0; i<maxSizeTestParameter; i++){
                sq2.poll();
            }
            assertNull(sq2.poll());
        }

        /**
         * Tests polling from the instance of {@link StringQueue}, after {@link StringQueue#offer(String)} one element.
         * @result Is equals, because we offer() an element and get the same back.
         */
        @Test
        public void poll5(){
            String parameter = "1";
            sq1.offer(parameter);
            assertEquals(parameter, sq1.poll());
        }

        /**
         * Tests polling if the instance of {@link StringQueue} is working like the FIFO principal, by {@link StringQueue#offer(String)}ing three elements.
         * @result Is equals, because the first offered parameter is tested and the queue works like the FIFO principal.
         */
        @Test
        public void poll6(){
            String parameter1 = "1";
            sq1.offer(parameter1);
            sq1.offer("2");
            sq1.offer("3");
            assertEquals(parameter1, sq1.poll());
        }

        /**
         * Tests polling from the instance of {@link StringQueue}, after {@link StringQueue#offer(String)}ing one element.
         * @result Is equals, because we offer() an element and get the same back.
         */
        @Test
        public void remove(){
            String parameter = "1";
            sq1.offer(parameter);
            assertEquals(parameter, sq1.poll());
        }

        /**
         * Tests polling from the instance of {@link StringQueue}, after {@link StringQueue#offer(String)}ing two elements.
         * @result Is not same, because after offering two elements we compare the first passed parmeter.
         */
        @Test
        public void remove2(){
            String parameter = "2";
            sq1.offer("1");
            sq1.offer(parameter);
            assertNotSame(parameter, sq1.poll());
        }

        /**
         * Tests to remove from empty instance of {@link StringQueue}.
         * @result {@link NoSuchElementException} is thrown.
         */
        @Test (expected = NoSuchElementException.class)
        public void remove3(){
            sq1.remove();
        }

        /**
         * Tests to remove more elements from the instance of {@link StringQueue} than {@link StringQueue#offer(String)}ed.
         * @result {@link NoSuchElementException} is thrown.
         * @throws  NoSuchElementException is expected
         */
        @Test (expected = NoSuchElementException.class)
        public void remove4(){
            sq1.offer("1");
            sq1.offer("2");
            sq1.offer("3");
            sq1.remove();
            sq1.remove();
            sq1.remove();
            sq1.remove();
        }

        /**
         * Tests the Exception message from {@link NoSuchElementException} thrown by {@link StringQueue#remove()}
         * @result Is equals.
         * @throws  NoSuchElementException is expected
         */
        @Test (expected = NoSuchElementException.class)
        public void remove5() throws NoSuchElementException {
            try {
                sq1.remove();
            }
            catch(NoSuchElementException re) {
                String message = "there's no element any more";
                assertEquals(message, re.getMessage());
                throw re;
            }
            fail("Employee Id Null exception did not throw!");
        }

        /**
         * Tests to get the {@link StringQueue#peek()} of an empty instance of {@link StringQueue}.
         * @result Is null, because there is no element in the queue.
         */
        @Test
        public void peek() {
            assertNull(sq1.peek());
        }

        /**
         * Tests to get the {@link StringQueue#peek()} from the instance of {@link StringQueue} after {@link StringQueue#offer(String)}ing one element.
         * @result It is equal, because the same element is passed.
         */
        @Test
        public void peek2() {
            String statement = "1";
            sq1.offer(statement);
            assertEquals(statement, sq1.peek());
        }

        /**
         * Tests to get the {@link StringQueue#peek()} from the instance of {@link StringQueue} after {@link StringQueue#offer(String)}ing two elements. Prove the FIFO principal.
         * @result It isn't equal, because the queue returns the first element and not the last offered.
         */
        @Test
        public void peek3() {
            String statement = "2";
            sq1.offer("1");
            sq1.offer(statement);
            assertNotSame(statement, sq1.peek());
        }

        /**
         * Tests to get the peek() from the instance of {@link StringQueue} after {@link StringQueue#offer(String)}ing an element.
         * @result Is not null, because the queue isn't empty.
         */
        @Test
        public void peek4() {
            sq1.offer("1");
            assertNotNull(sq1.peek());
        }
        /**
         * Tests to get the peek() from the instance of {@link StringQueue} after {@link StringQueue#offer(String)}ing an element.
         * @result Is equal, because just own element is added.
         */
        @Test
        public void peek5() {
            String parameter = "Hallo Leute, das ist ein Test!";
            sq1.offer(parameter);
            assertEquals(parameter, sq1.peek());
        }
        /**
         * Test to get the first elemenent of the instance of {@link StringQueue} without {@link StringQueue#offer(String)}ing a element.
         * @result {@link NoSuchElementException} is thrown.
         */
        @Test (expected = NoSuchElementException.class)
        public void element() {
            sq1.element();
        }

        /**
         * Test to get the first elemenent of the instance of{@link StringQueue} after {@link StringQueue#offer(String)}ing one element.
         * @result Is equals, because just one element is added to the queue;
         */
        @Test
        public void element2() {
            String parameter = "1";
            sq1.offer(parameter);
            assertEquals(parameter, sq1.element());
        }

        /**
         * Tests to get the {@link StringQueue#element()} from the instance of {@link StringQueue} after {@link StringQueue#offer(String)}ing two elements. Prove the FIFO principal.
         * @result It isn't equal, because the the queue returns the first element and not the last offered.
         */
        @Test public void element3(){
            String parameter = "2";
            sq1.offer("1");
            sq1.offer(parameter);
            assertNotSame(parameter, sq1.element());
        }

        /**
         * Tests the Exception message from {@link NoSuchElementException} thrown by {@link StringQueue#element()}
         * @result Is equals.
         * @throws  NoSuchElementException is expected
         */
        @Test (expected = NoSuchElementException.class)
        public void element4() throws NoSuchElementException {
            try {
                sq1.element();
            }
            catch(NoSuchElementException re) {
                String message = "there's no element any more";
                assertEquals(message, re.getMessage());
                throw re;
            }
            fail("Employee Id Null exception did not throw!");
        }
        /**
         * Test to get the first elemenent of the instance of{@link StringQueue} after {@link StringQueue#offer(String)}ing one element.
         * @result Is equals, because just one element is added to the queue;
         */
        @Test
        public void element5() {
            String parameter = "Alle Affen atzen am Affen Ahornbaum!";
            sq1.offer(parameter);
            assertEquals(parameter, sq1.element());
        }
    }