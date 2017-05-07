class Node
    attr_accessor :item, :next
    def initialize; end

    def initialize(item)
        @item = item.to_i
    end
end

#####

class LinkedList
    @first = Node
    def initialize; end

    ####

    def addItemAtEnd(item)
        if item != Node
            newNode = Node.new(item)
        elsif item == Node
            newNode = item
        else
            raise 'Invalid data type'
        end

        current = @first
        past = nil
        until current.nil?
            past = current
            current = current.next
        end
        if past.nil?
            @first = newNode
        else
            past.next = newNode
            newNode.next = current
        end
    end

    ####

    def addItemAtFirst(item)
        if item != Node
            newNode = Node.new(item)
        elsif item == Node
            newNode = item
        else
            raise 'Invalid data type'
        end
        if @first.nil?
            @first = newNode
        else
            newNode.next = @first
            @first = newNode
        end
   end

    ####

    def addItemToSortedList(item)
        if item != Node
            newNode = Node.new(item)
        elsif item == Node
            newNode = item
        else
            raise 'Invalid data type'
        end
        current = @first
        past = nil
        while !current.nil? && current.item < newNode.item
            past = current
            current = current.next
        end
        if past.nil?
            newNode.next = @first
            @first = newNode
        else
            past.next = newNode
            newNode.next = current
        end
      end

    ####

    def findItem(item)
        current = @first
        current = current.next while !current.nil? && current.item < item
        if current.nil? || current.item > item
            puts 'Item not found'
        else
            puts 'Item found'
        end
    end

    ####

    def deleteItem(item)
        current = @first
        past = nil
        while !current.nil? && current.item != item
            past = current
            current = current.next
        end
        puts 'Item not found' if current.nil? || current.item != item
        if past.nil?
            @first = current.next
        else
            past.next = current.next
        end
    end

    ####

    def reverse
        unless @first.nil?
            current = @first
            past = nil
            post = @first.next
            until current.next.nil?
                current.next = past
                past = current
                current = post
                post = post.next
            end
            current.next = past
            @first = current
        end
    end

    ####

    def printList
        current = @first
        until current.nil?
            puts current.item.to_i
            current = current.next
        end
    end
end

# LinkedListMain
ls = LinkedList .new
ls.addItemAtEnd(1)
ls.addItemAtEnd(5)
ls.addItemAtEnd(4)
ls.addItemAtEnd(3)
ls.addItemAtEnd(2)
ls.addItemAtFirst(18)
ls.addItemAtFirst(19)
ls.addItemToSortedList(84)
ls.addItemToSortedList(7)
ls.addItemToSortedList(2)
ls.addItemToSortedList(4)
ls.addItemToSortedList(7)
ls.addItemToSortedList(1)
ls.deleteItem(18)
ls.deleteItem(2)
ls.findItem(4)
ls.printList
